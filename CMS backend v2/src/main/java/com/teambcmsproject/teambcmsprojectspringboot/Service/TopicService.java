//January 22 2024 adding service class for organize code and function calling
package com.teambcmsproject.teambcmsprojectspringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.teambcmsproject.teambcmsprojectspringboot.exception.TopicNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Topic;
import com.teambcmsproject.teambcmsprojectspringboot.repository.TopicRepository;

@Service 
public class TopicService {
     @Autowired
    private TopicRepository topicRepository;
   
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    @SuppressWarnings("null")
    public Topic getTopicById(Long topic_id) {
        return topicRepository.findById(topic_id)
        .orElseThrow(() -> new TopicNotFoundException(topic_id));
    }

    public Topic saveTopic(Topic newTopic) {
        System.out.println(newTopic.getTopic_id());
        System.out.println(newTopic.getTopic_title());
        System.out.println(newTopic.getTopic_description());
        System.out.println(newTopic.getTopic_file());
        System.out.println(newTopic.getTopic_link());
        return topicRepository.save(newTopic);
    }

    @SuppressWarnings("null")
    public Topic updateTopic (@RequestBody Topic newTopic, @PathVariable Long topic_id){
      return  topicRepository.findById(topic_id)
      .map(topic ->{
        topic.setTopic_title(newTopic.getTopic_title());
        topic.setTopic_description(newTopic.getTopic_description());
        topic.setTopic_file(newTopic.getTopic_file());
        topic.setTopic_link(newTopic.getTopic_link());
        return topicRepository.save(topic);
        
      }).orElseThrow(()-> new TopicNotFoundException(topic_id));
  }

    @SuppressWarnings("null")
    public String deleteTopic(@PathVariable Long topic_id){
        if(!topicRepository.existsById(topic_id)){
            throw new TopicNotFoundException(topic_id);
        }
        topicRepository.deleteById(topic_id);
        return "Topic with id "+topic_id+" has been successfully deleted";
    }
}
//January 22 2024 adding service class for organize code and function calling
