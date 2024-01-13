//january 13 2024
package com.teambcmsproject.teambcmsprojectspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Chapter {
    @Id
    @GeneratedValue
    private Long chapter_id;
    private String chapter_title;
    private String chapter_description;
    private String chapter_file;
    private String chapter_link;
    private String course_title;


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

    public String getChapter_description() {
        return this.chapter_description;
    }

    public void setChapter_description(String chapter_description) {
        this.chapter_description = chapter_description;
    }

    public String getChapter_file() {
        return this.chapter_file;
    }

    public void setChapter_file(String chapter_file) {
        this.chapter_file = chapter_file;
    }

    public String getChapter_link() {
        return this.chapter_link;
    }

    public void setChapter_link(String chapter_link) {
        this.chapter_link = chapter_link;
    }

    public String getCourse_title() {
        return this.course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }
    

}
//january 13 2024