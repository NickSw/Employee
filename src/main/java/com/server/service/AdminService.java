package com.server.service;

import com.server.entity.Admin;
//TODO: ���������� service .Impl .Import .Export
public interface AdminService {
    public Admin getCredentials();
    public Admin updateCredentials(Admin admin);
    public void resetPassword();
}
