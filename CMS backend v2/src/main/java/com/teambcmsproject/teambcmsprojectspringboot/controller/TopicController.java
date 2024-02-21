// January 17, 2024
package com.teambcmsproject.teambcmsprojectspringboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.teambcmsproject.teambcmsprojectspringboot.Service.TopicService;
import com.teambcmsproject.teambcmsprojectspringboot.model.Topic;

@RestController
@RequestMapping("/api/topics") // Endpoint base path for topic related operations
@CrossOrigin("http://localhost:5173") // Allowing requests from this origin
public class TopicController {

    @Autowired // Injecting TopicService dependency
    private TopicService topicService;

    // January 22, 2024 modification for organize code and function calling

    // @PostMapping() // Original user
    // Topic newTopic(@RequestBody Topic newTopic) { // Creates a new topic
    //     return topicService.saveTopic(newTopic);
    // }

    //02/19/24

        @PostMapping("/uploadTopic")
        public ResponseEntity<String> uploadTopic(@RequestParam("topic_title") String topic_title,
                                                  @RequestParam("topic_file") MultipartFile topic_file,
                                                  @RequestParam("topic_description") String topic_description) {
            if (topic_file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }
    
            try {
                byte[] bytes = topic_file.getBytes();
                String originalFilename = topic_file.getOriginalFilename();
                @SuppressWarnings("null")
                String filenameWithoutPrefix = originalFilename.startsWith("PPT") ? originalFilename.substring(3) : originalFilename;
    
                // Save the file to a directory or cloud storage (you can use a service for this)
                topicService.saveTopicFile(bytes, filenameWithoutPrefix);
    
                // Now, save the topic details to the database
                Topic topic = new Topic();
                topic.setTopic_title(topic_title);
                topic.setTopic_file(bytes);
                topic.setTopic_description(topic_description);
    
                topicService.saveTopic(topic);
    
                return ResponseEntity.ok("Topic saved successfully");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save topic: " + e.getMessage());
            }
        }
    
    
    

        //02/19/24

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
