package com.teambcmsproject.teambcmsprojectspringboot.exception;

public class InstructorNotFound  extends RuntimeException{
    public InstructorNotFound(Long instructor_id){
        super("Could not found instructor with id" + instructor_id);
    }


}
