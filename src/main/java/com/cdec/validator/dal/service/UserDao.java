package com.cdec.validator.dal.service;

import com.cdec.validator.dal.model.UserEntity;
import com.cdec.validator.dal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {

    private final UserRepository userRepository;

    @Autowired
    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUserFromUserName(String username) {
        return userRepository.getUserFromUserName(username);
    }
}
