package com.server.service;

import com.server.entity.Admin;

public interface AdminService {
    public Admin getCredentials();
    public Admin updateCredentials(Admin admin);
}
