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

import com.teambcmsproject.teambcmsprojectspringboot.Service.ChapterService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;


@RestController
@RequestMapping("/api/chapters")
@CrossOrigin("http://localhost:5173")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;


     
    

    //January 22 2024 modification for organize code and function calling

    @PostMapping() 
    Chapter newChapter(@RequestBody Chapter newChapter) {
        return chapterService.saveChapter(newChapter);
    }

    @GetMapping() 
    List<Chapter> getAllChapter() {
        return chapterService.getAllChapter();

    }
    /* january 16 2024 updating instructor data and getinstructor by id */

    // show by id
    @GetMapping("/{chapter_id}")
    Chapter getChapterById(@PathVariable Long chapter_id) {
        return chapterService.getChapterById(chapter_id);
    }

    // edit data
    @PutMapping("/{chapter_id}")
    Chapter updateChapter(@RequestBody Chapter newChapter, @PathVariable Long chapter_id) {
        return chapterService.updateChapter(newChapter, chapter_id);
    }

    /* january 16 2024 */
    @DeleteMapping("/{chapter_id}")
    String deleteChapter(@PathVariable Long chapter_id) {
        return chapterService.deleteChapter(chapter_id);
    }

      @GetMapping("/byCourse/{course_id}")
    public List<Chapter> getChapterByCourseId(@PathVariable String chapter_id) {
        return chapterService.getChapterByCourseId(chapter_id);
    }

}
    //January 22 2024 modification for organize code and function calling
