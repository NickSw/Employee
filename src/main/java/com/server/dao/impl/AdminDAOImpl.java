package com.server.dao.impl;

import com.server.dao.AdminDAO;
import com.server.entity.Admin;
import com.server.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса AdminDAO
 * Методы:
 * Извлечь из таблицы admin запись логина и пароля администратора
 * Обновить данные администратора
 *
 * Осуществляется при помощи вспомогательного класса HibernateUtil
 */
@Repository
public class AdminDAOImpl implements AdminDAO{

    public AdminDAOImpl() {
        System.out.println("AdminDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Извлечь из базы запись администратора
     * TODO: ограничить записи в базе до одной
     * TODO: разобраться с warning и ошибками
     * TODO: использовать hibernateUtil
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public Admin getCredentials(){
        /**Достать все записи из базы*/
        List<Admin> admin = new ArrayList<Admin>();
        admin = sessionFactory.getCurrentSession().createQuery("FROM Admin").list();
        /**Берем первую запись*/
        if (admin.size() > 0) {
            return admin.get(0);
        } else {
            return null;
        }
    }

    /**
     * Обновить запись администратора в базе
     * @param admin
     * @return
     */
    @Override
    public Admin updateCredentials(Admin admin) {
        return hibernateUtil.update(admin);
    }

    @Override
    public void resetPassword(){
        Admin admin = new Admin();
        admin = getCredentials();
        admin.setPassword("rjkktl;");
        hibernateUtil.update(admin);
    }
}
