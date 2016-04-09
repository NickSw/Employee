package com.server.service.impl;

import com.server.dao.AdminDAO;
import com.server.dao.UserDAO;
import com.server.entity.Admin;
import com.server.entity.Roles;
import com.server.entity.Users;
import com.server.service.AdminService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("loadUserByUsername " + username);
        Admin admin = adminDAO.find(username);

        /*Admin admin = new Admin();
        admin.setName(username);
        admin.setPassword("11111");*/

        logger.info("finded user " + admin.getName());

        //List<GrantedAuthority> authorities = buildUserAuthority(user.getGrantedAuthority());
        //return buildUserForAuthentication(user, authorities);

        // указываем роли для этого пользователя
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        // на основании полученныйх даных формируем объект UserDetails
        // который позволит проверить введеный пользователем логин и пароль
        // и уже потом аутентифицировать пользователя
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(admin.getName(),
                        admin.getPassword(),
                        roles);

        return userDetails;
    }

    //благодаря колибри я понял что то что ниже не нужно, надо только заставить забирать данные из базы ..
    //а потом все урезать и отрефакторить
    //затем замена пароля
    //затем ajax

    // Converts com.server.entity.Users user to
    // org.springframework.security.core.userdetails.User
   /* private User buildUserForAuthentication(com.server.entity.Users user, List<GrantedAuthority> authorities) {
        logger.info("building user" + user.getUsername());
        return new User(user.getUsername(), user.getPassword(),user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Roles role) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        setAuths.add(new SimpleGrantedAuthority(role.getRoleName()));
        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
        return Result;
    }*/

}