package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;

@RestController
@RequestMapping("/api/instructors") // Endpoint base path for instructor related operations
@CrossOrigin("http://localhost:5173") // Allowing requests from this origin
public class InstructorController {

    @Autowired // Injecting InstructorService dependency
    private InstructorService instructorService;
    
    // January 22, 2024 modification for organize code and function calling

    @PostMapping() // Original user
    Instructor newInstructor(@RequestBody Instructor newInstructor) { // Creates a new instructor
        return instructorService.saveInstructor(newInstructor);
    }

    @GetMapping() // Original users
    List<Instructor> getAllInstructor() { // Retrieves all instructors
        return instructorService.getAllInstructor();
    }

    /* January 16, 2024 updating instructor data and get instructor by id */

    // Show by id 
    @GetMapping("/{instructor_id}")
    Instructor getInstructorById(@PathVariable Long instructor_id) { // Retrieves instructor by its ID
        return instructorService.getInstructorById(instructor_id);
    }

    // Edit data 
    @PutMapping("/{instructor_id}")
    Instructor updateInstructor(@RequestBody Instructor newInstructor, @PathVariable Long instructor_id) { // Updates instructor by its ID
        return instructorService.updateInstructor(newInstructor, instructor_id);
    }
    /* January 16, 2024 */

    @DeleteMapping("/{instructor_id}")
    String deleteInstructor(@PathVariable Long instructor_id) { // Deletes instructor by its ID
        return instructorService.deleteInstructor(instructor_id);
    }
      
    // January 22, 2024 modification for organize code and function calling
    //feb 13 2024
     @PostMapping("/{instructor_id}/courses")
    public ResponseEntity<Instructor> addCourseToInstructor(@PathVariable Long instructor_id, @RequestBody Course course) { // Adds course to instructor
        Instructor updatedInstructor = instructorService.addCourseToInstructor(instructor_id, course);
        if (updatedInstructor != null) {
            return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle course not found scenario
    }
        //feb 13 2024

}
