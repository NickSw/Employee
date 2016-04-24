package com.server.service.impl;

import com.server.dao.AdminDAO;
import com.server.entity.Admin;
import com.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Реализация интерфейса AdminService
 * Методы:
 * Извлечь из таблицы admin запись логина и пароля администратора
 * Обновить данные администратора
 *
 * Осуществляется при помощи слоя DAO
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
     * Извлечь запись администратора из базы
     * @return
     */
    @Override
    public Admin getCredentials(){
        return adminDAO.getCredentials();
    }

    /**
     * Обновить данные администратора
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
