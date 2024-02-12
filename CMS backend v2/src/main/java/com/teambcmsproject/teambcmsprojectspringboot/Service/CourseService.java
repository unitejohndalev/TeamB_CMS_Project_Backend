//January 22 2024 adding service class for organize code and function calling

package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.teambcmsproject.teambcmsprojectspringboot.exception.CourseNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.exception.TopicNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    //get all courses
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    //get courses by course id
    public Course getCourseById(Long course_id) {
        return courseRepository.findById(course_id)
                .orElseThrow(() -> new CourseNotFoundException(course_id));
    }

    // Create new course with chapter array
    public Course saveCourse(@RequestBody Course newCourse) {
        // Print course details (except ID)
        System.out.println("Course Title: " + newCourse.getCourse_title());
        System.out.println("Course Description: " + newCourse.getCourse_description());
        System.out.println("Course Start Date: " + newCourse.getCourse_start_date());
        System.out.println("Course End Date: " + newCourse.getCourse_end_date());

        // Save the newCourse entity
        Course savedCourse = courseRepository.save(newCourse);

        // Print associated chapter IDs
        if (savedCourse.getChapter() != null && !savedCourse.getChapter().isEmpty()) {
            for (Chapter chapter : savedCourse.getChapter()) {
                Long chapter_id = chapter.getChapter_id();
                System.out.println("Associated Chapter ID: " + chapter_id);
            }
        } else {
            System.out.println("No associated chapters found.");
        }

        // Return the savedCourse entity
        return savedCourse;
    }

    //add chapter inside the course
    public Course addChapterToCourse(Long course_id, Chapter chapter) {
        Course course = courseRepository.findById(course_id).orElse(null);
        if (course != null) {
            course.addChapter(chapter);
            return courseRepository.save(course);
        }
        return null; // Handle course not found scenario
    }

    //delete course
    public String deleteCourse(@PathVariable Long course_id) {
        if (!courseRepository.existsById(course_id)) {
            throw new TopicNotFoundException(course_id);
        }
        courseRepository.deleteById(course_id);
        return "Course with id " + course_id + " has been successfully deleted";
    }
    //update course
    public Course updateCourse(@RequestBody Course newCourse, @PathVariable Long course_id) {
        return courseRepository.findById(course_id)
                .map(course -> {
                    course.setCourse_title(newCourse.getCourse_title());
                    course.setCourse_description(newCourse.getCourse_description());
                    course.setCourse_start_date(newCourse.getCourse_start_date());
                    course.setCourse_end_date(newCourse.getCourse_end_date());
                    return courseRepository.save(course);

                }).orElseThrow(() -> new CourseNotFoundException(course_id));
    }

    public List<Course> getCourseByChapterId(Long chapter_id) {
        return courseRepository.findByChapterId(chapter_id);
    }

}
