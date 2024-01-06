package com.teambcmsproject.teambcmsprojectspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teambcmsproject.teambcmsprojectspringboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  

}
