// January 17, 2024
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
@RequestMapping("/api/topics") // Endpoint base path for topic related operations
@CrossOrigin("http://localhost:5173") // Allowing requests from this origin
public class TopicController {

    @Autowired // Injecting TopicService dependency
    private TopicService topicService;

    // January 22, 2024 modification for organize code and function calling

    @PostMapping() // Original user
    Topic newTopic(@RequestBody Topic newTopic) { // Creates a new topic
        return topicService.saveTopic(newTopic);
    }

    @GetMapping() // Original users
    List<Topic> getAllTopic() { // Retrieves all topics
        return topicService.getAllTopic();
    }

    /* January 16, 2024 updating chapter data and get chapter by id */

    // Show by id
    @GetMapping("/{topic_id}")
    Topic getTopicById(@PathVariable Long topic_id) { // Retrieves topic by its ID
        return topicService.getTopicById(topic_id);
    }

    // Edit data
    @PutMapping("/{topic_id}")
    Topic updateTopic(@RequestBody Topic newTopic, @PathVariable Long topic_id) { // Updates topic by its ID
        return topicService.updateTopic(newTopic, topic_id);
    }
    /* January 16, 2024 */

    @DeleteMapping("/{topic_id}")
    String deleteTopic(@PathVariable Long topic_id) { // Deletes topic by its ID
        return topicService.deleteTopic(topic_id);
    }
}
    // January 22, 2024 modification for organ
