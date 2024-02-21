//January 22 2024 adding service class for organize code and function calling
package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody;

import com.teambcmsproject.teambcmsprojectspringboot.exception.ChapterNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.exception.CourseNotFoundException; // Importing custom exception class
import com.teambcmsproject.teambcmsprojectspringboot.exception.TopicNotFoundException; // Importing custom exception class
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter; // Importing Chapter class
import com.teambcmsproject.teambcmsprojectspringboot.model.Course; // Importing Course class
import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository; // Importing CourseRepository class

@Service // Annotation to indicate this class as a service
public class CourseService {
    @Autowired // Annotation for dependency injection of CourseRepository bean
    private CourseRepository courseRepository; // Declaration of CourseRepository bean

    @Autowired
    private ChapterRepository chapterRepository;

    // Function to retrieve all courses
    public List<Course> getAllCourse() { // Method signature to retrieve all courses
        return courseRepository.findAll(); // referring to findAll() method of CourseRepository interface
    }

    // Function to retrieve a course by its ID
    public Course getCourseById(Long course_id) { // Method signature to retrieve a course by its ID
        return courseRepository.findById(course_id) // referring to findById() method of CourseRepository interface
                .orElseThrow(() -> new CourseNotFoundException(course_id)); // Handling CourseNotFoundException
    }

    // Function to create a new course with an array of chapters

    public Course saveCourse(@RequestBody Course newCourse) { // Method signature to create a new course
        // Printing course details (except ID)
        System.out.println("Course Title: " + newCourse.getCourse_title());
        System.out.println("Course Description: " + newCourse.getCourse_description());
        System.out.println("Course Start Date: " + newCourse.getCourse_start_date());
        System.out.println("Course End Date: " + newCourse.getCourse_end_date());
        return courseRepository.save(newCourse); // referring to  save() method of CourseRepository interface
    }
    

    // Function to add a chapter inside the course
    public Course addChapterToCourse(Long course_id, Chapter chapter) {
        Course course = courseRepository.findById(course_id)
                                        .orElseThrow(() -> new CourseNotFoundException(course_id));
        course.addChapter(chapter);
        return courseRepository.save(course);
    }
    

    // Function to delete a course by its ID
    // public String deleteCourse(@PathVariable Long course_id) { // Method signature to delete a course by its ID
    //     if (!courseRepository.existsById(course_id)) { // Checking if course exists
    //         throw new TopicNotFoundException(course_id); // Throwing TopicNotFoundException if course not found
    //     }
    //     courseRepository.deleteById(course_id); // Deleting course
    //     return "Course with id " + course_id + " has been successfully deleted"; // Returning success message
    // }
     
     // Function to delete a chapter by its ID
    
     
//try
    //delete
    public String deleteCourse(@PathVariable Long course_id) { // Method signature to delete a chapter by its ID
        if (!chapterRepository.existsById(course_id)) { // Checking if chapter exists
            throw new CourseNotFoundException(course_id); // Throwing ChapterNotFoundException if chapter not found
        }
        chapterRepository.deleteById(course_id); // Deleting chapter
        return "Course with id " + course_id + " has been successfully deleted"; // Returning success message
    }
//try

    // Function to update a course
    public Course updateCourse(@RequestBody Course newCourse, @PathVariable Long course_id) { // Method signature to update a course
        return courseRepository.findById(course_id) // referring to findById() method of CourseRepository interface
                .map(course -> { // Using map() to apply changes
                    course.setCourse_title(newCourse.getCourse_title()); // Updating course title
                    course.setCourse_description(newCourse.getCourse_description()); // Updating course description
                    course.setCourse_start_date(newCourse.getCourse_start_date()); // Updating course start date
                    course.setCourse_end_date(newCourse.getCourse_end_date()); // Updating course end date
                    return courseRepository.save(course); // Saving updated course
                }).orElseThrow(() -> new CourseNotFoundException(course_id)); // Handling CourseNotFoundException
    }

    // Function to retrieve courses by chapter ID
    public List<Course> getCourseByChapterId(Long chapter_id) { // Method signature to retrieve courses by chapter ID
        return courseRepository.findByChapterId(chapter_id); // referring to findByChapterId() method of CourseRepository interface
    }
}
//January 22 2024 adding service class for organize code and function calling