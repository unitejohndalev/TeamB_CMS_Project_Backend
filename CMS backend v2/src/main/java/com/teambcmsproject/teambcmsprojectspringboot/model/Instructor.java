package com.teambcmsproject.teambcmsprojectspringboot.model;

import jakarta.persistence.Entity; // Importing Entity annotation from jakarta.persistence package
import jakarta.persistence.GeneratedValue; // Importing GeneratedValue annotation from jakarta.persistence package
import jakarta.persistence.Id; // Importing Id annotation from jakarta.persistence package

@Entity
public class Instructor {
    
    @Id
    @GeneratedValue
    private Long instructor_id; // Unique identifier for the instructor

    private String instructor_first_name; // First name of the instructor
    private String instructor_last_name; // Last name of the instructor
    private String instructor_username; // Username of the instructor
    private String instructor_email; // Email of the instructor
    private char[] instructor_password; // Password of the instructor (stored as char array for security)
    private byte[] instructor_signature_data; // Signature data of the instructor (stored as byte array)
    private byte[] instructor_profile_picture_data; // Profile picture data of the instructor (stored as byte array)
    private String instructor_contact_number; // Contact number of the instructor

    // January 24, 2024: JPA relationship successfully integrated many-to-many

    // January 24, 2024: JPA relationship successfully integrated many-to-many

    public Long getInstructor_id() {
        return this.instructor_id; // Getter for instructor_id
    }

    public void setInstructor_id(Long instructor_id) {
        this.instructor_id = instructor_id; // Setter for instructor_id
    }

    public String getInstructor_first_name() {
        return this.instructor_first_name; // Getter for instructor_first_name
    }

    public void setInstructor_first_name(String instructor_first_name) {
        this.instructor_first_name = instructor_first_name; // Setter for instructor_first_name
    }

    public String getInstructor_last_name() {
        return this.instructor_last_name; // Getter for instructor_last_name
    }

    public void setInstructor_last_name(String instructor_last_name) {
        this.instructor_last_name = instructor_last_name; // Setter for instructor_last_name
    }

    public String getInstructor_username() {
        return this.instructor_username; // Getter for instructor_username
    }

    public void setInstructor_username(String instructor_username) {
        this.instructor_username = instructor_username; // Setter for instructor_username
    }

    public String getInstructor_email() {
        return this.instructor_email; // Getter for instructor_email
    }

    public void setInstructor_email(String instructor_email) {
        this.instructor_email = instructor_email; // Setter for instructor_email
    }

    public char[] getInstructor_password() {
        return this.instructor_password; // Getter for instructor_password
    }

    public void setInstructor_password(char[] instructor_password) {
        this.instructor_password = instructor_password; // Setter for instructor_password
    }

    public byte[] getInstructor_signature_data() {
        return this.instructor_signature_data; // Getter for instructor_signature_data
    }

    public void setInstructor_signature_data(byte[] instructor_signature_data) {
        this.instructor_signature_data = instructor_signature_data; // Setter for instructor_signature_data
    }

    public byte[] getInstructor_profile_picture_data() {
        return this.instructor_profile_picture_data; // Getter for instructor_profile_picture_data
    }

    public void setInstructor_profile_picture_data(byte[] instructor_profile_picture_data) {
        this.instructor_profile_picture_data = instructor_profile_picture_data; // Setter for instructor_profile_picture_data
    }

    public String getInstructor_contact_number() {
        return this.instructor_contact_number; // Getter for instructor_contact_number
    }

    public void setInstructor_contact_number(String instructor_contact_number) {
        this.instructor_contact_number = instructor_contact_number; // Setter for instructor_contact_number
    }
}
