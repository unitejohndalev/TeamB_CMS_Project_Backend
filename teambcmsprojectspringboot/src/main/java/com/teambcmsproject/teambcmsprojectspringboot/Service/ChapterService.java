//January 22 2024 adding service class for organize code and function calling
package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.teambcmsproject.teambcmsprojectspringboot.exception.ChapterNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.repository.ChapterRepository;
import com.teambcmsproject.teambcmsprojectspringboot.repository.CourseRepository;

@Service
public class ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    // @Autowired
    // private CourseRepository courseRepository;

    // getAllChapters
    public List<Chapter> getAllChapter() {
        return chapterRepository.findAll();
    }

    // getChapterbyID
    public Chapter getChapterById(Long chapter_id) {
        return chapterRepository.findById(chapter_id)
                .orElseThrow(() -> new ChapterNotFoundException(chapter_id));
    }

    // createNewChapter
    public Chapter saveChapter(Chapter newChapter) {
        System.out.println(newChapter.getChapter_title());
        System.out.println(newChapter.getChapter_date_created());
        return chapterRepository.save(newChapter);
    }

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

    
}


//January 22 2024 adding service class for organize code and function calling
