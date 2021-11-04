package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
