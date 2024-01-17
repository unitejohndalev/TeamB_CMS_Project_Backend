package com.teambcmsproject.teambcmsprojectspringboot.exception;

public class ChapterNotFoundException extends RuntimeException {
    public ChapterNotFoundException(Long chapter_id){
        super("Could not found the chapter with id  " + chapter_id);
    } 

}
