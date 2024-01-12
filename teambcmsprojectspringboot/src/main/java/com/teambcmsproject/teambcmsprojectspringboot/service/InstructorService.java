package com.teambcmsproject.teambcmsprojectspringboot.service;

import com.teambcmsproject.teambcmsprojectspringboot.exception.InstructorServiceException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;

import Mapper.InstructorMapper;

import java.util.ArrayList;
import java.util.List;

public class InstructorService {
 public List<Instructor> getAllInstructors() {

        List<Instructor> response = new ArrayList<>();

        try {
            log.info("UserService::getAllUsers execution started.");

            response = InstructorMapper.getAllInstructors();

        } catch (Exception e) {
            log.error(
                   "UserService::getAllUsers, Exception occurred while retrieving users from database, Exception message {}",
                    e.getMessage());
            throw new InstructorServiceException(
                    "UserService::getAllUsers, Exception occurred while fetching users from Database");
        }

        log.info("UserService::getAllUsers execution ended.");

        return response;
    }
}
