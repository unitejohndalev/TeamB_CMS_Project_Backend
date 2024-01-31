//January 22 2024 adding service class for organize code and function calling

package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    //   Long chapter_id = savedCourse.getChapter().getChapter_id();
    // }

    public Course saveCourse(Course newCourse) {
      System.out.println(newCourse.getCourse_id());
      System.out.println(newCourse.getCourse_title());
      System.out.println(newCourse.getCourse_description());
      System.out.println(newCourse.getCourse_start_date());
      System.out.println(newCourse.getCourse_end_date());
  
      // Save the newCourse entity
      Course savedCourse = courseRepository.save(newCourse);
  
      // Check if savedCourse is not null and has a chapter associated with it
      if (savedCourse != null && savedCourse.getChapter() != null) {
          Long chapter_id = savedCourse.getChapter().getChapter_id();
          System.out.println("Associated Chapter ID: " + chapter_id);
      } else {
          System.out.println("No associated chapter found.");
      }
  
      // Return the savedCourse entity
      return savedCourse;
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

  public List<Course> getCourseByInstructorId(Long instructor_id){
    return courseRepository.findByInstructorId(instructor_id);
}
public List<Course> getCourseByChapterId(Long chapter_id){
  return courseRepository.findByChapterId(chapter_id);
}
}
//January 22 2024 adding service class for organize code and function calling
