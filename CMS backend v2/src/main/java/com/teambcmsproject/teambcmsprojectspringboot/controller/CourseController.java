//january 24 2014
package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.Service.CourseService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;





@RestController
@RequestMapping("/api/course")
@CrossOrigin("http://localhost:5173")

public class CourseController {

  @Autowired
    private CourseService courseService;

        //January 22 2024 modification for organize code and function calling

 @PostMapping() //orginal user
    Course saveCourse (@RequestParam("course_title") String course_title,
                       @RequestParam("course_description") String course_description, 
                       @RequestParam("course_start_date") Date course_start_date, 
                       @RequestParam("course_end_date") Date course_end_date, 
                       @RequestParam("instructor_id") Long instructor_id){
     return courseService.saveCourse(course_title, course_description, course_start_date, course_end_date, instructor_id);
  }
   @GetMapping() //orginal users
  List<Course>getAllCourse(){
    return courseService.getAllCourse();


  }
/*january 16 2024 updating course data and getcourse by id*/

  //show by id 
  @GetMapping("/{course_id}")
  Course getCourseById(@PathVariable Long course_id){
    return courseService.getCourseById(course_id);
  }
 
  @GetMapping("/byInstructor/{instructor_id}")
    public List<Course> getCourseByInstructorId(@PathVariable Long instructor_id) {
        return courseService.getCourseByInstructorId(instructor_id);
    }


  //edit data 
  @PutMapping("/{course_id}")
  Course updateCourse(@RequestBody Course newCourse, @PathVariable Long course_id){
     return courseService.updateCourse(newCourse, course_id);
  }
    /*january 16 2024 */
   
    @DeleteMapping("/{course_id}")
        String deleteCourse(@PathVariable Long course_id){
           return courseService.deleteCourse(course_id);
        }
       //January 22 2024 modification for organize code and function calling
     


}
  
    

//january 13 2024