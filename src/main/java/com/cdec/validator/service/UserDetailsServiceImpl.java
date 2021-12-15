package com.cdec.validator.service;


import com.cdec.validator.dal.model.UserEntity;
import com.cdec.validator.dal.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.getUserFromUserName(username);
        return Optional.ofNullable(userEntity).map(
                user -> new User(user.getUsername(), user.getPassword(), new ArrayList<>())
        ).orElseThrow(() -> new UsernameNotFoundException("User name not found"));
    }
}