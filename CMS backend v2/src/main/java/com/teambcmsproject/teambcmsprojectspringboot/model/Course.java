//january 13 2024
package com.teambcmsproject.teambcmsprojectspringboot.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;
    private String course_title;
    private String course_description;
    private Date course_start_date;
    private Date course_end_date;
    // january 24 2024 jpa relationship successfully integrated many to many

    // january 24 2024 jpa relationship successfully integrated many to many

    // january 30 2024

    // February 6 2024
    // february 8 2024 bug fixed can add chapter inside course
   
    // mapping many to one from chapter
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Chapter> chapter;

    public List<Chapter> getChapter() {
        return this.chapter;
    }

    public void setChapter(List<Chapter> chapter) {
        this.chapter = chapter;
    }

    // used in addin chapter inside course
    @JsonIgnore
    public void addChapter(Chapter chapter) {
        chapter.setCourse(this); // Set the course for the chapter
        this.getChapter().add(chapter); // Add the chapter to the collection of chapters
    }
    // february 8 2024 bug fixed can add chapter inside course
    // february 6 2024

    public Long getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_title() {
        return this.course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_description() {
        return this.course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public Date getCourse_start_date() {
        return this.course_start_date;
    }

    public void setCourse_start_date(Date course_start_date) {
        this.course_start_date = course_start_date;
    }

    public Date getCourse_end_date() {
        return this.course_end_date;
    }

    public void setCourse_end_date(Date course_end_date) {
        this.course_end_date = course_end_date;
    }

}
// january 13 2024