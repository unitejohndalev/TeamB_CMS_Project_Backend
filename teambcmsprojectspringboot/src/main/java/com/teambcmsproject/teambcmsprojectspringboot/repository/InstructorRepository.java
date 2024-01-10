package com.teambcmsproject.teambcmsprojectspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;

public interface InstructorRepository extends JpaRepository <Instructor, Long>  {

}
