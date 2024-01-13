//january 13, 2024
package com.teambcmsproject.teambcmsprojectspringboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;


@RestController
@CrossOrigin("http://localhost:5173")

public class ChapterController {
    @Autowired
    private ChapterRepository chapterRepository;

    @PostMapping("/createChapter") //orginal user
        Chapter newChapter (@RequestBody Chapter newChapter){
        System.out.println(newChapter.getChapter_id());
        System.out.println(newChapter.getChapter_title());
        System.out.println(newChapter.getChapter_description());
        System.out.println(newChapter.getChapter_file());
        System.out.println(newChapter.getChapter_link());
        System.out.println(newChapter.getCourse_title());
        return chapterRepository.save(newChapter);
    }
    @GetMapping("/getChapter") //orginal users
    List<Chapter>getAllChapter(){
        return chapterRepository.findAll();


    }
}
//jaunary 13 2024