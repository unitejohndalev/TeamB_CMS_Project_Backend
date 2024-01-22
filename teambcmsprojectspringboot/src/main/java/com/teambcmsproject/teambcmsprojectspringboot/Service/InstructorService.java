package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.teambcmsproject.teambcmsprojectspringboot.exception.InstructorNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Instructor;
import com.teambcmsproject.teambcmsprojectspringboot.repository.InstructorRepository;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
   
    public List<Instructor> getAllInstructor() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorById(Long instructor_id) {
        return instructorRepository.findById(instructor_id)
        .orElseThrow(() -> new InstructorNotFoundException(instructor_id));
    }

    public Instructor saveInstructor(Instructor newInstructor) {
        System.out.println(newInstructor.getInstructor_first_name());
        System.out.println(newInstructor.getInstructor_last_name());
        System.out.println(newInstructor.getInstructor_username());
        System.out.println(newInstructor.getInstructor_id());
        System.out.println(newInstructor.getInstructor_email());
        return instructorRepository.save(newInstructor);
    }

    public  Instructor updateInstructor(@RequestBody Instructor newInstructor, @PathVariable Long instructor_id){
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

    public String deleteInstructor(@PathVariable Long instructor_id){
        if(!instructorRepository.existsById(instructor_id)){
            throw new InstructorNotFoundException(instructor_id);
        }
        instructorRepository.deleteById(instructor_id);
        return "Chapter with id "+instructor_id+" has been successfully deleted";
    }


}
