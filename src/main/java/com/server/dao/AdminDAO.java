package com.server.dao;

import com.server.entity.Admin;

public interface AdminDAO {
    public Admin getCredentials();
    public Admin updateCredentials(Admin admin);
    public void resetPassword();
}
