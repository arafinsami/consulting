package com.consulting.service;

import com.consulting.models.*;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
