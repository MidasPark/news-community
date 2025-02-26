package com.salt.auth.adapter.out;

import com.salt.auth.domain.User;
import com.salt.auth.port.out.UserRepositoryPort;

public class UserRepository implements UserRepositoryPort {
    @Override
    public void save(User user) {
        // 사용자 저장 로직
    }
} 