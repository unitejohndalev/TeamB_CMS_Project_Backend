package com.teambcmsproject.teambcmsprojectspringboot.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chapter_id;
    private String chapter_title;
    private String chapter_date_created;

    @JsonIgnore
    @ManyToMany(mappedBy = "chapters", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Course> course;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "chapter_topic_table", joinColumns = {
            @JoinColumn(name = "chap_id", referencedColumnName = "chapter_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    })
    private Set<Topic> topics;

    public Long getChapter_id() {
        return this.chapter_id;
    }

    public void setChapter_id(Long chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getChapter_title() {
        return this.chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

    public String getChapter_date_created() {
        return this.chapter_date_created;
    }
 public void setChapter_date_created(String chapter_date_created) {
        this.chapter_date_created = chapter_date_created;
    }

    public Set<Course> getCourse() {
        return this.course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    public Set<Topic> getTopics() {
        return this.topics;
    }

    public void setTopic(Set<Topic> topics) {
        this.topics = topics;
    }

}
