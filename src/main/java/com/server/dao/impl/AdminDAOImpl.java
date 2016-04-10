package com.server.dao.impl;

import com.server.dao.AdminDAO;
import com.server.entity.Admin;
import com.server.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAO{

    public AdminDAOImpl() {
        System.out.println("AdminDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public Admin getCredentials(){
        List<Admin> admin = new ArrayList<Admin>();
        admin = sessionFactory.getCurrentSession().createQuery("FROM Admin").list();
        if (admin.size() > 0) {
            return admin.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Admin updateCredentials(Admin admin) {
        return hibernateUtil.update(admin);
    }
}
