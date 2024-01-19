package com.teambcmsproject.teambcmsprojectspringboot.exception;

public class CourseInstructorIdNotFoundException extends RuntimeException {
    public CourseInstructorIdNotFoundException(int instructor_id){
        super("Could not found the course with id  " + instructor_id);
    }
}
