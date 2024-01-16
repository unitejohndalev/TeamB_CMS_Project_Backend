//january 13, 2024
package com.teambcmsproject.teambcmsprojectspringboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.exception.CourseNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;
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
/*january 16 2024 updating chapter data and getchapter by id*/
    //show by id 
  @GetMapping("/getChapter/{chapter_id}")
  Chapter getChapterById(@PathVariable Long chapter_id){
      return chapterRepository.findById(chapter_id)
      .orElseThrow(() -> new CourseNotFoundException(chapter_id));
  }
 

  //edit data 
  @PutMapping("/getChapter/{chapter_id}")
  Chapter updateChapter(@RequestBody Chapter newChapter, @PathVariable Long chapter_id){
      return  chapterRepository.findById(chapter_id)
      .map(chapter ->{
        chapter.setChapter_title(newChapter.getChapter_title());
        chapter.setChapter_description(newChapter.getChapter_description());
        chapter.setChapter_file(newChapter.getChapter_file());
        chapter.setChapter_link(newChapter.getChapter_link());
        chapter.setCourse_title(newChapter.getCourse_title());
        return chapterRepository.save(chapter);
        
      }).orElseThrow(()-> new CourseNotFoundException(chapter_id));
  }
    /*january 16 2024 */

}
//jaunary 13 2024