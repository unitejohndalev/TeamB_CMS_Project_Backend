package com.teambcmsproject.teambcmsprojectspringboot.model;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Chapter {
     @Id
     @GeneratedValue
     private Long chapter_id;
     private String chapter_title;
     private String chapter_date_created;

    //  @ManyToMany
    //  @JoinTable(
    //     name = "CourseCreated", //name of table wherein the 2 tables joined
    //     joinColumns = @JoinColumn(name = "chapter_id"), //join columns defining what columns are gonna be joined inside the table *chapter_id is the first Column*
    //     inverseJoinColumns = @JoinColumn (name = "course_id") //2nd column inside CreatedCourse table
    //     )

    // private Set<Course> courseAdded = new HashSet<>();

    

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
    
    // public Set<Course> getcourseAdded() {
    //     return courseAdded;
    // }


}
