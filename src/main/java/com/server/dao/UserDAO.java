package com.server.dao;

import com.server.entity.Users;

public interface UserDAO {
    Users findByUserName(String username);
}
