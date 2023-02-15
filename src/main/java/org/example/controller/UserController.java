package org.example.controller;


import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.example.auth.TokenUtils;
import org.example.domain.User;
import org.example.repository.UserMapper;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;


    private String accessToken;

    private String refreshToken;

    @Autowired
    TokenUtils tokenUtils;


    @ApiOperation(value = "회원가입", notes = "회원가입을 합니다")
    @PostMapping()
    public ResponseEntity createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("create User", HttpStatus.OK);
    }

    @ApiOperation(value = "유저조회", notes = "유저를 조회합니다")
    @RequestMapping(value = "/{UserId}", method = RequestMethod.GET)
    public User userInfo(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable("UserId") Long UserId) {
        return userService.getUserInfo(UserId);
    }

    @ApiOperation(value = "유저정보 최신화", notes = "유저정보를 최신화 합니다")
    @PutMapping("/{UserId}")
    public ResponseEntity updateUser(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long UserId, @RequestBody User user) {
        userService.updateUser(UserId, user);
        return new ResponseEntity<>("user Update", HttpStatus.OK);
    }

    @ApiOperation(value = "회원탈퇴", notes = "사이트에서 탈퇴합니다")
    @DeleteMapping("/{UserId}")
    public ResponseEntity deleteUser(@ApiParam(name = "id", value = "(required:id)", required = true) @PathVariable Long UserId) {
        userService.deleteUser(UserId);
        return new ResponseEntity<>("user Delete", HttpStatus.OK);
    }


    @ApiOperation(value = "로그인", notes = "이메일, 비밀번호로 로그인을 합니다")
    @PostMapping(value = "login")
    public ResponseEntity loginUser(@RequestBody User user) {

        String UserEmail = user.getUserEmail();
        String UserPw = user.getUserPw();

        User userPass = userService.getUserByEmailPw(UserEmail, UserPw);

        if (userPass != null) {
            accessToken = tokenUtils.createToken(userPass, true);
            refreshToken = tokenUtils.createToken(userPass, false);
            userService.updateToken(userPass.getUserEmail(), refreshToken);
            return new ResponseEntity<>("AccessToken: " + accessToken + "   RefreshToken:  " + refreshToken, HttpStatus.OK);

        } else {

            return new ResponseEntity<>("loginFail", HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "accessTokenReissue", notes = "accessToken을 재발급 합니다")
    @PostMapping("reissue")
    public ResponseEntity issueAccessToken() {

        if (!tokenUtils.isValidToken(accessToken)) {  //클라이언트에서 토큰 재발급 api로의 요청을 확정해주면 이 조건문은 필요 없을 것 같다.

            if (tokenUtils.isValidRefreshToken(refreshToken)) {     //들어온 Refresh 토큰이 자체적으로 유효한지

                Claims claimsToken = tokenUtils.getClaimsToken(refreshToken);
                Long userId = (Long) claimsToken.get("userId");
                User user = userMapper.getUserById(userId);
                String tokenFromDB = userMapper.getUserById(userId).getRefreshToken();

                if (refreshToken.equals(tokenFromDB)) {   //DB의 원본 refresh토큰과 지금들어온 토큰이 같은지 확인

                    accessToken = tokenUtils.createToken(user, true);
                    return new ResponseEntity<>("token Reissue", HttpStatus.OK);//"TokenReissue"
                } else {
                    return new ResponseEntity<>("Refresh Token Tampered", HttpStatus.BAD_REQUEST);
                    //DB의 Refresh토큰과 들어온 Refresh토큰이 다르면 중간에 변조된 것임
                    //예외발생

                }
            } else {
                return new ResponseEntity("Refresh Token is not valid", HttpStatus.BAD_REQUEST);
                //입력으로 들어온 Refresh 토큰이 유효하지 않음

            }
        }

        return new ResponseEntity<>("Token is still Okay", HttpStatus.OK);

    }

}
