package com.server.service.impl;

import com.server.dao.AdminDAO;
import com.server.entity.Admin;
import com.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    public AdminServiceImpl() {
        System.out.println("AdminServiceImpl()");
    }

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public Admin getCredentials(){
        return adminDAO.getCredentials();
    }

    @Override
    public Admin updateCredentials(Admin admin){
        return adminDAO.updateCredentials(admin);
    }
}
