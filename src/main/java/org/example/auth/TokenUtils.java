package org.example.auth;

import io.jsonwebtoken.*;
import org.example.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtils {

    @Value("${jwt.secret}")
    private  String SECRET_KEY ;
    @Value("${jwt.refresh}")
    private String REFRESH_KEY ;
    @Value(("${jwt.data}"))
    private String DATA_KEY;

    public String createToken(User usersEntity, Boolean AccessToken) {
        if (AccessToken) {
            return Jwts.builder()
                    .setSubject(String.valueOf(usersEntity.getUserId()))
                    .setHeader(createAccessHeader())
                    .setClaims(createClaims(usersEntity))
                    .setExpiration(createExpireDate(1000 * 60 * 30))
                    .signWith(SignatureAlgorithm.HS256, createSigningKey(SECRET_KEY))
                    .compact();
        }
        if (!AccessToken) {
            return Jwts.builder()
                    .setSubject(String.valueOf(usersEntity.getUserId()))
                    .setHeader(createRefreshHeader())
                    .setClaims(createClaims(usersEntity))
                    .setExpiration(createExpireDate(1000 * 60 * 60 * 24 * 14))
                    .signWith(SignatureAlgorithm.HS256, createSigningKey(REFRESH_KEY))
                    .compact();
        } else {
            return "false";
        }

    }

    public boolean isValidToken(String token) {
        //System.out.println("isValidToken is : " + token);
        try {
            Claims accessClaims = getClaimsFormToken(token);
            //System.out.println("Access expireTime: " + accessClaims.getExpiration());
            //System.out.println("Access userId: " + accessClaims.get("userId"));
            return true;
        } catch (ExpiredJwtException exception) {
            //System.out.println("Token Expired UserID : " + exception.getClaims().getSubject());
            return false;
        } catch (JwtException exception) {
            //System.out.println("Token Tampered");
            return false;
        } catch (NullPointerException exception) {
            //System.out.println("Token is null");
            return false;
        }
    }

    public boolean isValidRefreshToken(String token) {
        try {
            Claims accessClaims = getClaimsToken(token);
            //System.out.println("Access expireTime: " + accessClaims.getExpiration());
            //System.out.println("Access userId: " + accessClaims.get("userId"));
            return true;
        } catch (ExpiredJwtException exception) {
            //System.out.println("Token Expired UserID : " + exception.getClaims().getSubject());
            return false;
        } catch (JwtException exception) {
            //System.out.println("Token Tampered");
            return false;
        } catch (NullPointerException exception) {
            //System.out.println("Token is null");
            return false;
        }
    }


    private Date createExpireDate(long expireDate) {
        long curTime = System.currentTimeMillis();
        return new Date(curTime + expireDate);
    }

    private Map<String, Object> createAccessHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", "ACCESS_TOKEN");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());

        return header;
    }

    private Map<String, Object> createRefreshHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("typ", "ACCESS_TOKEN");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());

        return header;
    }

    private Map<String, Object> createClaims(User usersEntity) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(DATA_KEY, usersEntity.getUserId());
        return claims;
    }

    private Key createSigningKey(String key) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    private Claims getClaimsFormToken(String token) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token)
                .getBody();
    }

    public Claims getClaimsToken(String token) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(REFRESH_KEY))
                .parseClaimsJws(token)
                .getBody();
    }


}