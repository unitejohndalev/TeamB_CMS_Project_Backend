//january 24 2024 jpa relationship successfully integrated many to many

package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;
import com.teambcmsproject.teambcmsprojectspringboot.repository.TopicRepository;

@RestController
@RequestMapping("/chapter/topic")
public class ChapterTopicController {

       @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    public ChapterTopicController(ChapterRepository chapterRepository,
    TopicRepository topicRepository){
        this.chapterRepository = chapterRepository;
        this.topicRepository = topicRepository;
    }

    @PostMapping
    public Chapter saveChapterWithTopic(@RequestBody Chapter chapter){
        return chapterRepository.save(chapter);
    }
    
    @GetMapping
    public List <Chapter> findAllChapter(){
        return chapterRepository.findAll();
    }
    
    @GetMapping("/{chapter_id}")
    public Chapter findChapter(@PathVariable Long chapter_id){
        return chapterRepository.findById(chapter_id).orElse(null);
    }


}
//january 24 2024 jpa relationship successfully integrated many to many
