//january 13 2024
package com.teambcmsproject.teambcmsprojectspringboot.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    //january 30 2024
    //january 31 2024
    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name ="chapter_id")
    private Chapter chapter;

    public Chapter getChapter() {
        return this.chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
  //january 31 2024

   

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

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

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
// january 13 2024