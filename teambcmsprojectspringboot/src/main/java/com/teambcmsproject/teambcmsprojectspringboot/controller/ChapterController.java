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

import com.teambcmsproject.teambcmsprojectspringboot.exception.ChapterNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;


@RestController
@CrossOrigin("http://localhost:5173")
public class ChapterController {
    @Autowired
    private ChapterRepository chapterRepository;

    @PostMapping("/createChapter") // orginal user
    Chapter newChapter(@RequestBody Chapter newChapter) {
        System.out.println(newChapter.getChapter_title());
        System.out.println(newChapter.getChapter_date_created());
        return chapterRepository.save(newChapter);
    }

    @GetMapping("/getChapter") // orginal users
    List<Chapter> getAllChapter() {
        return chapterRepository.findAll();

    }
    /* january 16 2024 updating instructor data and getinstructor by id */

    // show by id
    @GetMapping("/getChapter/{chapter_id}")
    Chapter getChapterById(@PathVariable Long chapter_id) {
        return chapterRepository.findById(chapter_id)
                .orElseThrow(() -> new ChapterNotFoundException(chapter_id));
    }

    // edit data
    @PutMapping("/getChapter/{chapter_id}")
    Chapter updateChapter(@RequestBody Chapter newChapter, @PathVariable Long chapter_id) {
        return chapterRepository.findById(chapter_id)
                .map(chapter -> {
                    chapter.setChapter_title(newChapter.getChapter_title());
                    chapter.setChapter_date_created(newChapter.getChapter_date_created());

                    return chapterRepository.save(chapter);

                }).orElseThrow(() -> new ChapterNotFoundException(chapter_id));
    }

    /* january 16 2024 */
    @DeleteMapping("/getChapter/{chapter_id}")
    String deleteChapter(@PathVariable Long chapter_id) {
        if (!chapterRepository.existsById(chapter_id)) {
            throw new ChapterNotFoundException(chapter_id);
        }
        chapterRepository.deleteById(chapter_id);
        return "Chapter with id " + chapter_id + " has been successfully deleted";
    }
    
}
