//january 17, 2024
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

import com.teambcmsproject.teambcmsprojectspringboot.Service.TopicService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Topic;

@RestController
@RequestMapping("/api/topics")
@CrossOrigin("http://localhost:5173")

public class TopicController {

    @Autowired
    private TopicService topicService;

    // January 22 2024 modification for organize code and function calling

    @PostMapping() // orginal user
    Topic newTopic(@RequestBody Topic newTopic) {
        return topicService.saveTopic(newTopic);
    }

    @GetMapping() // orginal users
    List<Topic> getAllTopic() {
        return topicService.getAllTopic();
    }

    /* january 16 2024 updating chapter data and getchapter by id */
    // show by id
    @GetMapping("/{topic_id}")
    Topic getTopicById(@PathVariable Long topic_id) {
        return topicService.getTopicById(topic_id);
    }

    // edit data
    @PutMapping("/{topic_id}")
    Topic updateTopic(@RequestBody Topic newTopic, @PathVariable Long topic_id) {
        return topicService.updateTopic(newTopic, topic_id);
    }
    /* january 16 2024 */

    @DeleteMapping("/{topic_id}")
    String deleteTopic(@PathVariable Long topic_id) {
        return topicService.deleteTopic(topic_id);
    }

    // January 22 2024 modification for organize code and function calling
    //try
    @GetMapping("/byChapter/{chapter_id}")
    public List<Topic> getChapterByCourseId(@PathVariable Long chapter_id) {
        return topicService.getTopicByChapterId(chapter_id);
    }
    //try
}
// jaunary 13 2024