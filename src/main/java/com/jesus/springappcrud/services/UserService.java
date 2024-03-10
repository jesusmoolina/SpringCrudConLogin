package com.jesus.springappcrud.services;

import com.jesus.springappcrud.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);


    boolean existsByUsername(String username);

}
