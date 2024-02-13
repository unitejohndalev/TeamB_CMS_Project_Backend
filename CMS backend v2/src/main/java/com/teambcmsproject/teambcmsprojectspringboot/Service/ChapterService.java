//January 22 2024 adding service class for organize code and function calling
package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.teambcmsproject.teambcmsprojectspringboot.exception.ChapterNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Topic;
import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;


@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    // getAllChapters
    public List<Chapter> getAllChapter() {
        return chapterRepository.findAll();
    }

    // getChapterbyID
    public Chapter getChapterById(Long chapter_id) {
        return chapterRepository.findById(chapter_id)
                .orElseThrow(() -> new ChapterNotFoundException(chapter_id));
    }

    // // createNewChapter
    // public Chapter saveChapter(@RequestBody Chapter newChapter) {
    //     System.out.println(newChapter.getChapter_title());
    //     System.out.println(newChapter.getChapter_date_created());
    //     return chapterRepository.save(newChapter);

    // }




    // update chapter
    public Chapter updateChapter(@RequestBody Chapter newChapter, @PathVariable Long chapter_id) {
        return chapterRepository.findById(chapter_id)
                .map(chapter -> {
                    chapter.setChapter_title(newChapter.getChapter_title());
                    chapter.setChapter_date_created(newChapter.getChapter_date_created());

                    return chapterRepository.save(chapter);

                }).orElseThrow(() -> new ChapterNotFoundException(chapter_id));
    }

    public String deleteChapter(@PathVariable Long chapter_id) {
        if (!chapterRepository.existsById(chapter_id)) {
            throw new ChapterNotFoundException(chapter_id);
        }
        chapterRepository.deleteById(chapter_id);
        return "Chapter with id " + chapter_id + " has been successfully deleted";
    }

    public List<Chapter> getChapterByCourseId(Long course_id){
      return chapterRepository.findByCourse_id(course_id);
  }

  //try
     public Chapter saveChapter(@RequestBody Chapter newChapter) {
        // Print course details (except ID)
        System.out.println("Chapter Title: " + newChapter.getChapter_title());
        System.out.println("Chapter Date Created: " + newChapter.getChapter_date_created());

        // Save the newCourse entity
        Chapter savedChapter = chapterRepository.save(newChapter);

        // Print associated chapter IDs
        if (savedChapter.getTopic() != null && !savedChapter.getTopic().isEmpty()) {
            for (Topic topic : savedChapter.getTopic()) {
                Long topic_id = topic.getTopic_id();
                System.out.println("Associated Topic ID: " + topic_id);
            }
        } else {
            System.out.println("No associated Topic found.");
        }
        return savedChapter;
    }

    public Chapter addTopicToChapter(Long chapter_id, Topic topic) {
        Chapter chapter = chapterRepository.findById(chapter_id).orElse(null);
        if (chapter != null) {
            chapter.addTopic(topic);
            return chapterRepository.save(chapter);
        }
        return null; // Handle course not found scenario
    }

  //try
    
}


//January 22 2024 adding service class for organize code and function calling
