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

import com.teambcmsproject.teambcmsprojectspringboot.Service.ChapterService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Topic;


@RestController
@RequestMapping("/api/chapters")
@CrossOrigin("http://localhost:5173")
public class ChapterController {
    
    @Autowired
    private ChapterService chapterService;

  
    //POST MAPPING FOR CREATING NEW CHAPTER
    @PostMapping() 
    public Chapter saveChapter(@RequestBody Chapter newChapter) {
        return chapterService.saveChapter(newChapter);
    }

    //GET MAPPING FOR GETTING ALL CHAPTERS
    @GetMapping() 
    List<Chapter> getAllChapter() {
        return chapterService.getAllChapter();
    }

    //GET MAPPING FOR GETTING CHAPTERS BY ID
    @GetMapping("/{chapter_id}")
    Chapter getChapterById(@PathVariable Long chapter_id) {
        return chapterService.getChapterById(chapter_id);
    }

    //PUT MAPPING FOR UPDATING CHAPTERS BY ID
    @PutMapping("/{chapter_id}")
    Chapter updateChapter(@RequestBody Chapter newChapter, @PathVariable Long chapter_id) {
        return chapterService.updateChapter(newChapter, chapter_id);
    }

    //DELETE MAPPING TO UPDATE CHAPTERS BY ID
    @DeleteMapping("/{chapter_id}")
    String deleteChapter(@PathVariable Long chapter_id) {
        return chapterService.deleteChapter(chapter_id);
    }
   //GET MAPPING TO GETTING CHAPTERS BY COURSE ID
    @GetMapping("/byCourse/{course_id}")
    public List<Chapter> getChapterByCourseId(@PathVariable Long course_id) {
        return chapterService.getChapterByCourseId(course_id);
    }

    //try
    @PostMapping("/{chapter_id}/topics")
    public ResponseEntity<Chapter> addTopicToChapter(@PathVariable Long chapter_id, @RequestBody Topic topic) {
      Chapter updatedChapter = chapterService.addTopicToChapter(chapter_id, topic);
      if (updatedChapter != null) {
        return new ResponseEntity<>(updatedChapter, HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Handle course not found scenario
    }
    //try
}
