package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.Service.InstructorService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;


@RestController
@RequestMapping("/api/instructors")
@CrossOrigin("http://localhost:5173")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;
    
        //January 22 2024 modification for organize code and function calling

     @PostMapping() //orginal user
    Instructor newInstructor(@RequestBody Instructor newInstructor){
     return instructorService.saveInstructor(newInstructor);
  }

  @GetMapping() //orginal users
  List<Instructor>getAllInstructor(){
    return instructorService.getAllInstructor();


  }
/*january 16 2024 updating instructor data and getinstructor by id*/

  //show by id 
  @GetMapping("/{instructor_id}")
  Instructor getInstructorById(@PathVariable Long instructor_id){
     return instructorService.getInstructorById(instructor_id);
  }
 

  //edit data 
  @PutMapping("/{instructor_id}")
  Instructor updateInstructor(@RequestBody Instructor newInstructor, @PathVariable Long instructor_id){
     return instructorService.updateInstructor(newInstructor, instructor_id);
  }
  /*january 16 2024 */
  @DeleteMapping("/{instructor_id}")
  String deleteInstructor(@PathVariable Long instructor_id){
      return instructorService.deleteInstructor(instructor_id);
        }
      
     //January 22 2024 modification for organize code and function calling

}
