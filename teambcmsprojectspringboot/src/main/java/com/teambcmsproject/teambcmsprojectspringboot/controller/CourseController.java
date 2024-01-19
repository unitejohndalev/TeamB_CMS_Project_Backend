//january 24 2014
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
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;
import org.springframework.web.bind.annotation.RequestParam;





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
/*january 16 2024 updating course data and getcourse by id*/

  //show by id 
  @GetMapping("/getCourse/{course_id}")
  Course getCourseById(@PathVariable Long course_id){
      return courseRepository.findById(course_id)
      .orElseThrow(() -> new CourseNotFoundException(course_id));
  }
 

  //edit data 
  @PutMapping("/getCourse/{course_id}")
  Course updateCourse(@RequestBody Course newCourse, @PathVariable Long course_id){
      return  courseRepository.findById(course_id)
      .map(course ->{
        course.setCourse_title(newCourse.getCourse_title());
        course.setCourse_description(newCourse.getCourse_description());
        course.setCourse_start_date(newCourse.getCourse_start_date());
        course.setCourse_end_date(newCourse.getCourse_end_date());
        course.setChapter_title(newCourse.getChapter_title());
        return courseRepository.save(course);
        
      }).orElseThrow(()-> new CourseNotFoundException(course_id));
  }
    /*january 16 2024 */
   
    @DeleteMapping("/getCourse/{course_id}")
        String deleteCourse(@PathVariable Long course_id){
            if(!courseRepository.existsById(course_id)){
                throw new TopicNotFoundException(course_id);
            }
            courseRepository.deleteById( course_id);
            return "Course with id "+course_id+" has been successfully deleted";
        }
  @GetMapping("/getCourseByInstructorId/{instructor_id}")
    Course getCourseByInstructorId(@PathVariable Long instructor_id){
      return courseRepository.findById(instructor_id)
      .orElseThrow(() -> new CourseNotFoundException(instructor_id));
    }
    

}
  
    

//january 13 2024