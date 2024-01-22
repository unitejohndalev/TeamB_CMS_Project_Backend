package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.Service.ChapterService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
// import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
// import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;
// import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;

@RestController
@CrossOrigin("http://localhost:5173")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
     
    // @Autowired
    // private ChapterRepository chapterRepository;

    // @Autowired
    // private CourseRepository courseRepository;

    //January 22 2024 modification for organize code and function calling

    @PostMapping("/createChapter") 
    Chapter newChapter(@RequestBody Chapter newChapter) {
        return chapterService.saveChapter(newChapter);
    }

    @GetMapping("/getChapter") 
    List<Chapter> getAllChapter() {
        return chapterService.getAllChapter();

    }
    /* january 16 2024 updating instructor data and getinstructor by id */

    // show by id
    @GetMapping("/getChapter/{chapter_id}")
    Chapter getChapterById(@PathVariable Long chapter_id) {
        return chapterService.getChapterById(chapter_id);
    }

    // edit data
    @PutMapping("/getChapter/{chapter_id}")
    Chapter updateChapter(@RequestBody Chapter newChapter, @PathVariable Long chapter_id) {
        return chapterService.updateChapter(newChapter, chapter_id);
    }

    /* january 16 2024 */
    @DeleteMapping("/getChapter/{chapter_id}")
    String deleteChapter(@PathVariable Long chapter_id) {
        return chapterService.deleteChapter(chapter_id);
    }

    // @PutMapping("getChapter/{chapter_id}/course/{course_id}"){
    //    Chapter addChapterToCourse(
    //         @PathVariable Long chapter_id,
    //         @PathVariable Long course_id
    //     ){
    //         Optional<Chapter> chapter = chapterRepository.findById(course_id);
    //         Optional<Course> course = courseRepository.findById(course_id);
    //     }
    // }

}
    //January 22 2024 modification for organize code and function calling
