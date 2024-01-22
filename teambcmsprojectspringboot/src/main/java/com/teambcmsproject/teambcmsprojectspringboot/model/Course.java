//january 13 2024
package com.teambcmsproject.teambcmsprojectspringboot.model;


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
    private String course_start_date;
    private String course_end_date;
    private String chapter_title;
    private Long instructor_id;

    // @ManyToMany(mappedBy = "courseCreated")
    // private Set<Chapter> chapters = new HashSet<>();



    public Long getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getInstructor_id() {
        return this.instructor_id;
    }

    public void setInstructor_id(Long instructor_id) {
        this.instructor_id = instructor_id;
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

    public String getCourse_start_date() {
        return this.course_start_date;
    }

    public void setCourse_start_date(String course_start_date) {
        this.course_start_date = course_start_date;
    }

    public String getCourse_end_date() {
        return this.course_end_date;
    }

    public void setCourse_end_date(String course_end_date) {
        this.course_end_date = course_end_date;
    }

    public String getChapter_title() {
        return this.chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }
    
    // public Set<Chapter> getChapters() {
    //     return chapters;
    // }
}
//january 13 2024