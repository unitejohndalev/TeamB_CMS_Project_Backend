//January 22 2024 adding service class for organize code and function calling
package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.teambcmsproject.teambcmsprojectspringboot.exception.InstructorNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;     
import com.teambcmsproject.teambcmsprojectspringboot.repository.InstructorRepository;

@Service // Annotation to indicate this class as a service
public class InstructorService {
    @Autowired // Annotation for dependency injection of InstructorRepository bean
    private InstructorRepository instructorRepository; // Declaration of InstructorRepository bean

    // Function to retrieve all instructors
    public List<Instructor> getAllInstructor() { // Method signature to retrieve all instructors
        return instructorRepository.findAll(); // referring to findAll() method of InstructorRepository interface
    }

    // Function to retrieve an instructor by its ID
    public Instructor getInstructorById(Long instructor_id) { // Method signature to retrieve an instructor by its ID
        return instructorRepository.findById(instructor_id) // referring to  findById() method of InstructorRepository interface
        .orElseThrow(() -> new InstructorNotFoundException(instructor_id)); // Handling InstructorNotFoundException
    }

    // Function to save a new instructor
    public Instructor saveInstructor(Instructor newInstructor) { // Method signature to save a new instructor
        // Printing instructor details
        System.out.println(newInstructor.getInstructor_first_name());
        System.out.println(newInstructor.getInstructor_last_name());
        System.out.println(newInstructor.getInstructor_username());
        System.out.println(newInstructor.getInstructor_id());
        System.out.println(newInstructor.getInstructor_email());
        return instructorRepository.save(newInstructor); // referring to  save() method of InstructorRepository interface
    }

     // Function to add a chapter inside the course
    public Instructor addCourseToInstructor(Long instructor_id, Course course) { // Method signature to add a chapter inside the course
        Instructor instructor = instructorRepository.findById(instructor_id).orElse(null); // Retrieving course by ID
        if (instructor != null) { // Checking if course exists
            instructor.addCourse(course); // Adding chapter to course
            return instructorRepository.save(instructor); // Saving updated course
        }
        return null; // Returning null if course not found
    }

    // Function to update an instructor
    @SuppressWarnings("null") // Suppressing warnings related to null value
    public  Instructor updateInstructor(@RequestBody Instructor newInstructor, @PathVariable Long instructor_id){ // Method signature to update an instructor
      return  instructorRepository.findById(instructor_id) // referring to findById() method of InstructorRepository interface
      .map(instructor ->{ // Using map() to apply changes
        instructor.setInstructor_first_name(newInstructor.getInstructor_first_name()); // Updating instructor first name
        instructor.setInstructor_last_name(newInstructor.getInstructor_last_name()); // Updating instructor last name
        instructor.setInstructor_username(newInstructor.getInstructor_username()); // Updating instructor username
        instructor.setInstructor_email(newInstructor.getInstructor_email()); // Updating instructor email
        instructor.setInstructor_password(newInstructor.getInstructor_password()); // Updating instructor password
        instructor.setInstructor_profile_picture_data(newInstructor.getInstructor_profile_picture_data()); // Updating instructor profile picture data
        instructor.setInstructor_signature_data(newInstructor.getInstructor_signature_data()); // Updating instructor signature data
        instructor.setInstructor_contact_number(newInstructor.getInstructor_contact_number()); // Updating instructor contact number
        return instructorRepository.save(instructor); // Saving updated instructor
      }).orElseThrow(()-> new InstructorNotFoundException(instructor_id)); // Handling InstructorNotFoundException
  }

    // Function to delete an instructor by its ID
    @SuppressWarnings("null") // Suppressing warnings related to null value
    public String deleteInstructor(@PathVariable Long instructor_id){ // Method signature to delete an instructor by its ID
        if(!instructorRepository.existsById(instructor_id)){ // Checking if instructor exists
            throw new InstructorNotFoundException(instructor_id); // Throwing InstructorNotFoundException if instructor not found
        }
        instructorRepository.deleteById(instructor_id); // Deleting instructor
        return "Chapter with id "+instructor_id+" has been successfully deleted"; // Returning success message
    }
}
//January 22 2024 adding service class for organize code and function calling