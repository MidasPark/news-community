package com.salt.auth.port.in;

import com.salt.auth.domain.User;

public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(User user) {
        // 사용자 등록 로직 구현
        System.out.println("User " + user.getUsername() + " registered successfully!");
    }
} 