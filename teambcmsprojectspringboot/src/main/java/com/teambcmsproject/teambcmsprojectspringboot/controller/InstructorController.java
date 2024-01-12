package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;
import com.teambcmsproject.teambcmsprojectspringboot.repository.InstructorRepository;

@RestController
@CrossOrigin("http://localhost:5173")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;
     
     @PostMapping("/instructor") //orginal user
    Instructor newInstructor(@RequestBody Instructor newInstructor){
      System.out.println(newInstructor.getInstructor_first_name());
      System.out.println(newInstructor.getInstructor_last_name());
      System.out.println(newInstructor.getInstructor_username());
      System.out.println(newInstructor.getInstructor_id());
      System.out.println(newInstructor.getInstructor_email());
    return instructorRepository.save(newInstructor);
  }

  @GetMapping("/instructors") //orginal users
  List<Instructor>getAllInstructors(){
    return instructorRepository.findAll();


  }

}
