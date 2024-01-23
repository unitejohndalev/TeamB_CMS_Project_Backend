//january 13 2024
package com.teambcmsproject.teambcmsprojectspringboot.model;


import java.sql.Date;

// import java.util.HashSet;
// import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// import jakarta.persistence.ManyToMany;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long course_id;
    private String course_title;
    private String course_description; 
    private Date course_start_date;
    private Date course_end_date;


    // @ManyToMany(mappedBy = "courseCreated")
    // private Set<Chapter> chapters = new HashSet<>();
    



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

  
  
    
    // public Set<Chapter> getChapters() {
    //     return chapters;
    // }
}
//january 13 2024