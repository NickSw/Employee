package com.server.service.impl;

import com.server.dao.AdminDAO;
import com.server.entity.Admin;
import com.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ���������� ���������� AdminService
 * ������:
 * ������� �� ������� admin ������ ������ � ������ ��������������
 * �������� ������ ��������������
 *
 * �������������� ��� ������ ���� DAO
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    public AdminServiceImpl() {
        System.out.println("AdminServiceImpl()");
    }

    @Autowired
    private AdminDAO adminDAO;

    /**
     * ������� ������ �������������� �� ����
     * @return
     */
    @Override
    public Admin getCredentials(){
        return adminDAO.getCredentials();
    }

    /**
     * �������� ������ ��������������
     * @param admin
     * @return
     */
    @Override
    public Admin updateCredentials(Admin admin){
        return adminDAO.updateCredentials(admin);
    }

    public void resetPassword(){
        adminDAO.resetPassword();
    }
}
