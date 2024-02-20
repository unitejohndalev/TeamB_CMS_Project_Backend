package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; // Importing annotation for dependency injection

import org.springframework.stereotype.Service; // Importing annotation to indicate this class as a service
import org.springframework.web.bind.annotation.PathVariable; // Importing annotation to indicate a method parameter is bound to a URI template variable
import org.springframework.web.bind.annotation.RequestBody; // Importing annotation to indicate a method parameter should be bound to the body of the web request
import org.springframework.web.multipart.MultipartFile;

import com.teambcmsproject.teambcmsprojectspringboot.exception.TopicNotFoundException; // Importing custom exception class
import com.teambcmsproject.teambcmsprojectspringboot.model.Topic; // Importing Topic class
import com.teambcmsproject.teambcmsprojectspringboot.repository.TopicRepository; // Importing TopicRepository class

@Service // Annotation to indicate this class as a service
public class TopicService {
    @Autowired // Annotation for dependency injection of TopicRepository bean
    private TopicRepository topicRepository; // Declaration of TopicRepository bean

    // Function to retrieve all topics
    public List<Topic> getAllTopic() { // Method signature to retrieve all topics
        return topicRepository.findAll(); // referring to findAll() method of TopicRepository interface
    }

    // Function to retrieve a topic by its ID
    public Topic getTopicById(Long topic_id) { // Method signature to retrieve a topic by its ID
        return topicRepository.findById(topic_id) // referring to findById() method of TopicRepository interface
        .orElseThrow(() -> new TopicNotFoundException(topic_id)); // Handling TopicNotFoundException
    }

    //02/19/2024

        //02/19/2024


        //2-20-24        
       public void saveTopicFile(byte[] bytes, String filenameWithoutPrefix) throws IOException {
        // Specify the directory where you want to save the files
        String directoryPath = "C:\\Users\\vsbu\\Documents";

        // Create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create a File object with the specified directory and filename
        File file = new File(directoryPath + filenameWithoutPrefix);

        // Write the byte array to the file
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);
        }
    }
    public void saveTopic(Topic topic) {
        topicRepository.save(topic);
    }
        
        
        //2-20-24

    // Function to update a topic
    public Topic updateTopic (@RequestBody Topic newTopic, @PathVariable Long topic_id){ // Method signature to update a topic
      return  topicRepository.findById(topic_id) // referring to findById() method of TopicRepository interface
      .map(topic ->{ // Using map() to apply changes
        topic.setTopic_title(newTopic.getTopic_title()); // Updating topic title
        topic.setTopic_description(newTopic.getTopic_description()); // Updating topic description
        // topic.setTopic_file(newTopic.getTopic_file()); // Updating topic file
        topic.setTopic_link(newTopic.getTopic_link()); // Updating topic link
        return topicRepository.save(topic); // Saving updated topic
      }).orElseThrow(()-> new TopicNotFoundException(topic_id)); // Handling TopicNotFoundException
  }

    // Function to delete a topic by its ID
    public String deleteTopic(@PathVariable Long topic_id){ // Method signature to delete a topic by its ID
        if(!topicRepository.existsById(topic_id)){ // Checking if topic exists
            throw new TopicNotFoundException(topic_id); // Throwing TopicNotFoundException if topic not found
        }
        topicRepository.deleteById(topic_id); // Deleting topic
        return "Topic with id "+topic_id+" has been successfully deleted"; // Returning success message
    }

    // Function to retrieve topics by chapter ID
    public List<Topic> getTopicByChapterId(Long chapter_id){ // Method signature to retrieve topics by chapter ID
        return topicRepository.findByChapter_id(chapter_id); // referring to findByChapter_id() method of TopicRepository interface
    }

  

    
}
