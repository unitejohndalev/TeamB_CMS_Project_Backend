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
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.Service.ChapterService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;

@RestController
@CrossOrigin("http://localhost:5173")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @PostMapping("/createChapter") // orginal user
    Chapter newChapter(@RequestBody Chapter newChapter) {
        return chapterService.saveChapter(newChapter);
    }

    @GetMapping("/getChapter") // orginal users
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

}
