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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.Service.CourseService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;





@RestController
@RequestMapping("/api/courses")
@CrossOrigin("http://localhost:5173")

public class CourseController {

  @Autowired
    private CourseService courseService;

        //January 22 2024 modification for organize code and function calling

 @PostMapping() //orginal user
    Course newCourse (@RequestBody Course newCourse){
     return courseService.saveCourse(newCourse);
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
    @GetMapping("/byChapter/{chapter_id}")
    public List<Course> getCourseByChapterId(@PathVariable Long chapter_id) {
        return courseService.getCourseByChapterId(chapter_id);
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