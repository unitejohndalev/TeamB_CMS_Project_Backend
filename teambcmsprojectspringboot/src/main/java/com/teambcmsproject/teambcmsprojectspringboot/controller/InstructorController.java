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
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.exception.TopicNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.exception.CourseNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.exception.InstructorNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;
import com.teambcmsproject.teambcmsprojectspringboot.repository.InstructorRepository;



@RestController
@CrossOrigin("http://localhost:5173")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;
     
     @PostMapping("/createInstructor") //orginal user
    Instructor newInstructor(@RequestBody Instructor newInstructor){
      System.out.println(newInstructor.getInstructor_first_name());
      System.out.println(newInstructor.getInstructor_last_name());
      System.out.println(newInstructor.getInstructor_username());
      System.out.println(newInstructor.getInstructor_id());
      System.out.println(newInstructor.getInstructor_email());
    return instructorRepository.save(newInstructor);
  }

  @GetMapping("/getInstructor") //orginal users
  List<Instructor>getAllInstructors(){
    return instructorRepository.findAll();


  }
/*january 16 2024 updating instructor data and getinstructor by id*/

  //show by id 
  @GetMapping("/getInstructor/{instructor_id}")
  Instructor getInstructorById(@PathVariable Long instructor_id){
      return instructorRepository.findById(instructor_id)
      .orElseThrow(() -> new CourseNotFoundException(instructor_id));
  }
 

  //edit data 
  @PutMapping("/getInstructor/{instructor_id}")
  Instructor updateInstructor(@RequestBody Instructor newInstructor, @PathVariable Long instructor_id){
      return  instructorRepository.findById(instructor_id)
      .map(instructor ->{
        instructor.setInstructor_first_name(newInstructor.getInstructor_first_name());
        instructor.setInstructor_last_name(newInstructor.getInstructor_last_name());
        instructor.setInstructor_username(newInstructor.getInstructor_username());
        instructor.setInstructor_email(newInstructor.getInstructor_email());
        instructor.setInstructor_password(newInstructor.getInstructor_password());
        instructor.setInstructor_profile_picture_data(newInstructor.getInstructor_profile_picture_data());
        instructor.setInstructor_signature_data(newInstructor.getInstructor_signature_data());
        instructor.setInstructor_contact_number(newInstructor.getInstructor_contact_number());
        return instructorRepository.save(instructor);
        
      }).orElseThrow(()-> new InstructorNotFoundException(instructor_id));
  }
  /*january 16 2024 */
  @DeleteMapping("/getInstructor/{instructor_id}")
        String deleteInstructor(@PathVariable Long instructor_id){
            if(!instructorRepository.existsById(instructor_id)){
                throw new TopicNotFoundException(instructor_id);
            }
            instructorRepository.deleteById(instructor_id);
            return "Chapter with id "+instructor_id+" has been successfully deleted";
        }
      
 
}
