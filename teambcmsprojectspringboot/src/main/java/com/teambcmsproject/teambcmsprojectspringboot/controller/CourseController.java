//january 24 2014
package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;


@RestController
@CrossOrigin("http://localhost:5173")

public class CourseController {

  @Autowired
    private CourseRepository courseRepository;

 @PostMapping("/createCourse") //orginal user
    Course newCourse (@RequestBody Course newCourse){
      System.out.println(newCourse.getCourse_id());
      System.out.println(newCourse.getInstructor_id());
      System.out.println(newCourse.getCourse_title());
      System.out.println(newCourse.getCourse_description());
      System.out.println(newCourse.getCourse_start_date());
      System.out.println(newCourse.getCourse_end_date());
    return courseRepository.save(newCourse);
  }
   @GetMapping("/getCourse") //orginal users
  List<Course>getAllCourse(){
    return courseRepository.findAll();


  }

}
//january 13 2024