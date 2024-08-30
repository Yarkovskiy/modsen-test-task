package com.example.modsentesttask.service;

import com.example.modsentesttask.domain.user.User;

public interface UserService {

    User getById(Long id);

    User getByUsername(String username);

    User update(User user);

    User create(User user);

    void delete(Long id);

}
