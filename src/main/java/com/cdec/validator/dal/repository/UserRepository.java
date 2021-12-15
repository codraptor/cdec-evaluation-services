package com.cdec.validator.dal.repository;

import com.cdec.validator.dal.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, String> {

    @Query("SELECT user FROM UserEntity user where user.username = ?1")
    UserEntity getUserFromUserName(String username);

}
