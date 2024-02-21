package com.teambcmsproject.teambcmsprojectspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType; // Importing CascadeType from jakarta.persistence package
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue; // Importing GeneratedValue from jakarta.persistence package
import jakarta.persistence.Id; // Importing Id from jakarta.persistence package
import jakarta.persistence.JoinColumn; // Importing JoinColumn from jakarta.persistence package
import jakarta.persistence.ManyToOne; // Importing ManyToOne from jakarta.persistence package

@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Long topic_id; // Unique identifier for the topic
    private String topic_title; // Title of the topic
    private String topic_description; // Description of the topic
    private byte[] topic_file; // File associated with the topic
    private String topic_link; // Link associated with the topic

    // January 24, 2024: JPA relationship successfully integrated many-to-many
    
    // February 13, 2024: Done fixing bugs with JPA relationship
    
    // JPA relationship one-to-many between Chapter and Topic
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="chapter_id")
    private Chapter chapter; // Associated chapter for the topic

    public Chapter getChapter() {
        return this.chapter; // Getter for associated chapter
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter; // Setter for associated chapter
    }

    // January 24, 2024: JPA relationship successfully integrated many-to-many

    public Long getTopic_id() {
        return this.topic_id; // Getter for topic_id
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id; // Setter for topic_id
    }

    public String getTopic_title() {
        return this.topic_title; // Getter for topic_title
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title; // Setter for topic_title
    }

    public String getTopic_description() {
        return this.topic_description; // Getter for topic_description
    }

    public void setTopic_description(String topic_description) {
        this.topic_description = topic_description; // Setter for topic_description
    }

  

    public String getTopic_link() {
        return this.topic_link; // Getter for topic_link
    }

    public void setTopic_link(String topic_link) {
        this.topic_link = topic_link; // Setter for topic_link
    }
    public byte[] getTopic_file() {
        return this.topic_file;
    }

    public void setTopic_file(byte[] topic_file) {
        this.topic_file = topic_file;
    }
}
// January 17, 2024
