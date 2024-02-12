//january 24 2014
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

import com.teambcmsproject.teambcmsprojectspringboot.Service.CourseService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("http://localhost:5173")

public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    CourseRepository courseRepository;

    // January 22 2024 modification for organize code and function calling
    
    //API FOR CREATE NEW COURSE
    @PostMapping() // orginal user
    Course newCourse(@RequestBody Course newCourse) {
      return courseService.saveCourse(newCourse);
    }
    //API FOR GET ALL COURSE BY CALLING COURSE ID
    @GetMapping()
    List<Course> getAllCourse() {
      return courseService.getAllCourse();
    }
    /* january 16 2024 updating course data and getcourse by id */

    // show by id
    //API FOR GET COURSE BY CALLING COURSE ID
    @GetMapping("/{course_id}")
    Course getCourseById(@PathVariable Long course_id) {
      return courseService.getCourseById(course_id);
    }

    // @GetMapping("/byInstructor/{instructor_id}")
    // public List<Course> getCourseByInstructorId(@PathVariable Long instructor_id)
    // {
    // return courseService.getCourseByInstructorId(instructor_id);
    // }

    // january 31 2024
    //API FOR GET COURSE BY CALLING CHAPTER ID
    @GetMapping("/byChapter/{chapter_id}")
    public List<Course> getCourseByChapterId(@PathVariable Long chapter_id) {
      return courseService.getCourseByChapterId(chapter_id);
    }
    // //january 31 2024

    //API FOR UPDATING COURSE BY CALLING COURSE ID
    @PutMapping("/{course_id}")
    Course updateCourse(@RequestBody Course newCourse, @PathVariable Long course_id) {
      return courseService.updateCourse(newCourse, course_id);
    }
    /* january 16 2024 */

    //API FOR DELETING COURSE BY CALLING COURSE ID
    @DeleteMapping("/{course_id}")
    String deleteCourse(@PathVariable Long course_id) {
      return courseService.deleteCourse(course_id);
    }
    // January 22 2024 modification for organize code and function calling

    //API for adding chapter inside the course by calling course id
    @PostMapping("/{course_id}/chapters")
    public ResponseEntity<Course> addChapterToCourse(@PathVariable Long course_id, @RequestBody Chapter chapter) {
      Course updatedCourse = courseService.addChapterToCourse(course_id, chapter);
      if (updatedCourse != null) {
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle course not found scenario
    }
   

}