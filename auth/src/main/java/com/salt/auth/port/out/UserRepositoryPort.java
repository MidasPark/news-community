package com.salt.auth.port.out;

import com.salt.auth.domain.User;

public interface UserRepositoryPort {
    void save(User user);
} 