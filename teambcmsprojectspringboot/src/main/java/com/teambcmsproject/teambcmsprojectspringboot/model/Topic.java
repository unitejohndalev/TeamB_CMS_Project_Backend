package com.teambcmsproject.teambcmsprojectspringboot.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Long topic_id;
    private String topic_title;
    private String topic_description;
    private String topic_file;
    private String topic_link;
//january 24 2024 jpa relationship successfully integrated many to many

    @JsonIgnore
    @ManyToMany(mappedBy = "topics", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Chapter> chapter;
//january 24 2024 jpa relationship successfully integrated many to many

  

    public Long getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_title() {
        return this.topic_title;
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title;
    }

    public String getTopic_description() {
        return this.topic_description;
    }

    public void setTopic_description(String topic_description) {
        this.topic_description = topic_description;
    }

    public String getTopic_file() {
        return this.topic_file;
    }

    public void setTopic_file(String topic_file) {
        this.topic_file = topic_file;
    }

    public String getTopic_link() {
        return this.topic_link;
    }

    public void setTopic_link(String topic_link) {
        this.topic_link = topic_link;
    }


    public Set<Chapter> getChapter() {
        return this.chapter;
    }

    public void setChapter(Set<Chapter> chapter) {
        this.chapter = chapter;
    }
   

}
// january 17 2024
