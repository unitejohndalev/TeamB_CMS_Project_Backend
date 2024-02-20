// January 24, 2014
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
@RequestMapping("/api/courses") // Endpoint base path for course related operations
@CrossOrigin("http://localhost:5173") // Allowing requests from this origin
public class CourseController {

    @Autowired // Injecting CourseService dependency
    private CourseService courseService;

    @Autowired // Injecting CourseRepository dependency
    CourseRepository courseRepository;

    // January 22, 2024 modification for organize code and function calling
    
    // API FOR CREATE NEW COURSE
    @PostMapping() // Original user
    Course newCourse(@RequestBody Course newCourse) { // Creates a new course
        return courseService.saveCourse(newCourse);
    }

    // API FOR GET ALL COURSE BY CALLING COURSE ID
    @GetMapping() 
    List<Course> getAllCourse() { // Retrieves all courses
        return courseService.getAllCourse();
    }

    /* January 16, 2024 updating course data and get course by id */

    // Show by id
    // API FOR GET COURSE BY CALLING COURSE ID
    @GetMapping("/{course_id}")
    Course getCourseById(@PathVariable Long course_id) { // Retrieves course by its ID
        return courseService.getCourseById(course_id);
    }

    // January 31, 2024
    // API FOR GET COURSE BY CALLING CHAPTER ID
    @GetMapping("/byChapter/{chapter_id}")
    public List<Course> getCourseByChapterId(@PathVariable Long chapter_id) { // Retrieves courses by chapter ID
        return courseService.getCourseByChapterId(chapter_id);
    }
    // January 31, 2024

    // API FOR UPDATING COURSE BY CALLING COURSE ID
    @PutMapping("/{course_id}")
    Course updateCourse(@RequestBody Course newCourse, @PathVariable Long course_id) { // Updates course by its ID
        return courseService.updateCourse(newCourse, course_id);
    }
    /* January 16, 2024 */

    // API FOR DELETING COURSE BY CALLING COURSE ID @DeleteMapping("/{course_id}/chapters/{chapter_id}")
    // public ResponseEntity<?> deleteChapterById(@PathVariable Long course_id, @PathVariable Long chapter_id) {
    //     // Call service method to delete chapter
    //     courseService.deleteChapterById(chapter_id);
    //     return ResponseEntity.ok().build();
    // }

//try
    @DeleteMapping("/{course_id}")
    public String deleteCourse(@PathVariable Long course_id) { // Method signature to delete a chapter by its ID
        return courseService.deleteCourse(course_id);
    }
    //try
    // January 22, 2024 modification for organize code and function calling

    // API for adding chapter inside the course by calling course id
    @PostMapping("/{course_id}/chapters")
    public ResponseEntity<Course> addChapterToCourse(@PathVariable Long course_id, @RequestBody Chapter chapter) { // Adds chapter to course
        Course updatedCourse = courseService.addChapterToCourse(course_id, chapter);
        if (updatedCourse != null) {
            return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle course not found scenario
    }
}
