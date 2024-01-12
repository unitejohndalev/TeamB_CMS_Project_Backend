package com.teambcmsproject.teambcmsprojectspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Instructor {
    
    @Id
    @GeneratedValue
    private Long instructor_id;
    private String instructor_first_name;
    private String instructor_last_name;
    private String instructor_username; 
    private String instructor_email;
    private char[] instructor_password;
    private byte[] instructor_signature_data;
    private byte[] instructor_profile_picture_data;



    public Long getInstructor_id() {
        return this.instructor_id;
    }

    public void setInstructor_id(Long instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_first_name() {
        return this.instructor_first_name;
    }

    public void setInstructor_first_name(String instructor_first_name) {
        this.instructor_first_name = instructor_first_name;
    }

    public String getInstructor_last_name() {
        return this.instructor_last_name;
    }

    public void setInstructor_last_name(String instructor_last_name) {
        this.instructor_last_name = instructor_last_name;
    }

    public String getInstructor_username() {
        return this.instructor_username;
    }

    public void setInstructor_username(String instructor_username) {
        this.instructor_username = instructor_username;
    }

    public String getInstructor_email() {
        return this.instructor_email;
    }

    public void setInstructor_email(String instructor_email) {
        this.instructor_email = instructor_email;
    }

    public char[] getInstructor_password() {
        return this.instructor_password;
    }

    public void setInstructor_password(char[] instructor_password) {
        this.instructor_password = instructor_password;
    }

    public byte[] getInstructor_signature_data() {
        return this.instructor_signature_data;
    }

    public void setInstructor_signature_data(byte[] instructor_signature_data) {
        this.instructor_signature_data = instructor_signature_data;
    }

    public byte[] getInstructor_profile_picture_data() {
        return this.instructor_profile_picture_data;
    }

    public void setInstructor_profile_picture_data(byte[] instructor_profile_picture_data) {
        this.instructor_profile_picture_data = instructor_profile_picture_data;
    }


   }