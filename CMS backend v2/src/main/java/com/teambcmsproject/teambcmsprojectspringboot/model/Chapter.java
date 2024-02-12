package com.teambcmsproject.teambcmsprojectspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chapter_id;
    private String chapter_title;
    private String chapter_date_created;
    // january 30 2024

    // february 8 2024 bug fixed can add chapter inside course

    // MANY TO ONE RELATIONSHIP BETWEEN COURSE AND CHAPTER
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // february 8 2024 bug fixed can add chapter inside course

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

}