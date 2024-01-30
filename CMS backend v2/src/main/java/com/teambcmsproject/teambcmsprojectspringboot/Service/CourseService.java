//January 22 2024 adding service class for organize code and function calling

package com.teambcmsproject.teambcmsprojectspringboot.Service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


import com.teambcmsproject.teambcmsprojectspringboot.exception.CourseNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.exception.TopicNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    
   



     public List<Course> getAllCourse() {
            return courseRepository.findAll();
    }

    public Course getCourseById(Long course_id) {
        return courseRepository.findById(course_id)
        .orElseThrow(() -> new CourseNotFoundException(course_id));
    }

    // public Course saveCourse(Course newCourse) {
    //     System.out.println(newCourse.getCourse_id());
    //     System.out.println(newCourse.getCourse_title());
    //     System.out.println(newCourse.getCourse_description());
    //     System.out.println(newCourse.getCourse_start_date());
    //     System.out.println(newCourse.getCourse_end_date());



    //   return courseRepository.save(newCourse);
    // }


    public Course saveCourse(@RequestParam("course_title") String course_title, 
                                                     @RequestParam("course_description") String course_description, 
                                                     @RequestParam("course_start_date") Date course_start_date, 
                                                     @RequestParam("course_end_date") Date course_end_date, 
                                                     @RequestParam("instructor_id") Long instructor_id) {
       
            Course course = new Course();
            course.setCourse_title(course_title);
            course.setCourse_description(course_description);
            course.setCourse_start_date(course_start_date);
            course.setCourse_end_date(course_end_date);
            
            return courseRepository.save(course);

        
    }
    public List<Course> getCourseByInstructorId(Long instructor_id){
      return courseRepository.findByInstructorId(instructor_id);
  }

    public String deleteCourse(@PathVariable Long course_id){
            if(!courseRepository.existsById(course_id)){
                throw new TopicNotFoundException(course_id);
            }
            courseRepository.deleteById(course_id);
            return "Course with id "+course_id+" has been successfully deleted";
    }
    
    public Course updateCourse(@RequestBody Course newCourse, @PathVariable Long course_id){
      return  courseRepository.findById(course_id)
      .map(course ->{
        course.setCourse_title(newCourse.getCourse_title());
        course.setCourse_description(newCourse.getCourse_description());
        course.setCourse_start_date(newCourse.getCourse_start_date());
        course.setCourse_end_date(newCourse.getCourse_end_date());
        return courseRepository.save(course);
        
      }).orElseThrow(()-> new CourseNotFoundException(course_id));
  }

  


}


//January 22 2024 adding service class for organize code and function calling
