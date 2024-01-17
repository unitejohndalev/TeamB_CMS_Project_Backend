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
import org.springframework.web.bind.annotation.RestController;

import com.teambcmsproject.teambcmsprojectspringboot.exception.TopicNotFoundException;
import com.teambcmsproject.teambcmsprojectspringboot.model.Topic;
import com.teambcmsproject.teambcmsprojectspringboot.repository.TopicRepository;


@RestController
@CrossOrigin("http://localhost:5173")

public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping("/createTopic") //orginal user
        Topic newTopic (@RequestBody Topic newTopic){
        System.out.println(newTopic.getTopic_id());
        System.out.println(newTopic.getTopic_title());
        System.out.println(newTopic.getTopic_description());
        System.out.println(newTopic.getTopic_file());
        System.out.println(newTopic.getTopic_link());
        System.out.println(newTopic.getChapter_title());
        return topicRepository.save(newTopic);
    }
    @GetMapping("/getTopic") //orginal users
    List<Topic>getAllTopic(){
        return topicRepository.findAll();


    }
/*january 16 2024 updating chapter data and getchapter by id*/
    //show by id 
  @GetMapping("/getTopic/{topic_id}")
  Topic getTopicById(@PathVariable Long topic_id){
      return topicRepository.findById(topic_id)
      .orElseThrow(() -> new TopicNotFoundException(topic_id));
  }
 

  //edit data 
  @PutMapping("/getTopic/{topic_id}")
  Topic updateTopic (@RequestBody Topic newTopic, @PathVariable Long topic_id){
      return  topicRepository.findById(topic_id)
      .map(topic ->{
        topic.setTopic_title(newTopic.getTopic_title());
        topic.setTopic_description(newTopic.getTopic_description());
        topic.setTopic_file(newTopic.getTopic_file());
        topic.setTopic_link(newTopic.getTopic_link());
        topic.setChapter_title(newTopic.getChapter_title());
        return topicRepository.save(topic);
        
      }).orElseThrow(()-> new TopicNotFoundException(topic_id));
  }
    /*january 16 2024 */

    @DeleteMapping("/getTopic/{topic_id}")
        String deleteTopic(@PathVariable Long topic_id){
            if(!topicRepository.existsById(topic_id)){
                throw new TopicNotFoundException(topic_id);
            }
            topicRepository.deleteById(topic_id);
            return "Topic with id "+topic_id+" has been successfully deleted";
        }
}
//jaunary 13 2024