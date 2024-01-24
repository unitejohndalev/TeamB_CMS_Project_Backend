//january 24 2024 jpa relationship successfully integrated many to many

package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/course/chapter")
public class CourseChapterController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    public CourseChapterController(CourseRepository courseRepository,
    ChapterRepository chapterRepository){
        this.courseRepository = courseRepository;
        this.chapterRepository = chapterRepository;
    }

    @PostMapping
    public Course saveCourseWithChapter(@RequestBody Course course){
        return courseRepository.save(course);
    }
    
    @GetMapping
    public List <Course> findAllCourse(){
        return courseRepository.findAll();
    }
    
    @GetMapping("/{course_id}")
    public Course findCourse(@PathVariable Long course_id){
        return courseRepository.findById(course_id).orElse(null);
    }

  
}
//january 24 2024 jpa relationship successfully integrated many to many
