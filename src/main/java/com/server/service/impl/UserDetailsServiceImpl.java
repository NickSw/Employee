package com.server.service.impl;

import com.server.dao.AdminDAO;
import com.server.entity.Admin;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс для Spring Security
 * Проверка введенных данных Spring Security
 *      TODO: должен использовать сервисный слой
 * Используется слой DAO для администратора
 */
@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private AdminDAO adminDAO;

    /**
     * username передается в этот метод из скрипта js
     * username - admin
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /**Извлечь запись админа*/
        Admin admin = adminDAO.getCredentials();

        /**Указание роли*/
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        /***
         * на основании полученныйх даных формируем объект UserDetails
         * который позволит проверить введеный пользователем логин и пароль
         * и уже потом аутентифицировать пользователя
         * */
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(admin.getName(),
                        admin.getPassword(),
                        roles);

        return userDetails;
    }
}