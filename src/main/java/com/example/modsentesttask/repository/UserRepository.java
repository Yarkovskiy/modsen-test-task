package com.example.modsentesttask.repository;

import com.example.modsentesttask.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
