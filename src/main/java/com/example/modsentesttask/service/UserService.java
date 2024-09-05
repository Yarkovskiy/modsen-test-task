package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.user.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User getByUsername(String username);

    boolean existsById(Long id);

    User update(User user);

    User create(User user);

    void delete(Long id);

}
