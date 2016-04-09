package com.server.dao.impl;

import com.server.dao.UserDAO;
import com.server.entity.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public Users findByUserName(String username) {
/*
        logger.info("findByUserName" + username);

        List<Users> users = new ArrayList<Users>();

        users = sessionFactory.getCurrentSession()
                .createQuery("FROM Users where username =: username")
                .setParameter("username", username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

*/
        Users user = new Users();
        user.setUsername(username);
        user.setPassword("11111");

        return user;
    }

}
