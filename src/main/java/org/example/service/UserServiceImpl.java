package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.repository.UserMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Transactional
    public User getUserInfo(long UserId) {
        return userMapper.getUserById(UserId);
    }

    @Transactional
    public void createUser(User user) {
        userMapper.create(user);
    }

    @Transactional
    public void updateUser(long UserId, User updateUser) {
        User userTest = userMapper.getUserById(UserId);

        if (userTest != null) {
            userTest.setUserPw(updateUser.getUserPw());
            userTest.setUserAddress(updateUser.getUserAddress());
            userTest.setUserEmail(updateUser.getUserEmail());
            userTest.setUserName(updateUser.getUserName());
            userTest.setUserPhone(updateUser.getUserPhone());
            userTest.setRegisterDate(updateUser.getRegisterDate());
            userTest.setUpdateDate(updateUser.getUpdateDate());
            userTest.setDeleteDate(updateUser.getDeleteDate());//setter말고 builder 패턴 사용
            userMapper.update(userTest);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다.");
        }
    }

    @Transactional
    public void deleteUser(long UserId) {
        if (userMapper.getUserById(UserId) != null) {
            userMapper.delete(UserId);
        } else {
            throw new IllegalStateException("회원이 존재하지 않습니다");//exception처리가 어디에서 나는 알아보기
        }
    }

    @Transactional
    public User getUserByEmailPw(String UserEmail, String UserPw) {

        User user = new User();
        user.setUserEmail(UserEmail);
        user.setUserPw(UserPw);
        return userMapper.getUserByEmailPw(user);
    }


    @Transactional
    public void updateToken(String UserEmail, String RefreshToken) {
        User userToken = userMapper.getUserByEmail(UserEmail);
        if (userToken != null) {
            userToken.setRefreshToken(RefreshToken);
            userMapper.updateToken(userToken);
        }
    }

}
