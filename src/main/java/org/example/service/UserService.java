package org.example.service;


import org.example.domain.User;

import java.util.Optional;

public interface UserService {
    User getUserInfo(long UserId);

    void createUser(User user);

    void updateUser(long UserId, User user);

    void deleteUser(long UserId);


    User getUserByEmailPw(String UserEmail, String UserPw);

    void updateToken(String UserEmail, String RefreshToken);
}
