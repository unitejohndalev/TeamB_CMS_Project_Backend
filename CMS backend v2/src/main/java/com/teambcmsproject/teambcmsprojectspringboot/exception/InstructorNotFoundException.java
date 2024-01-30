
  /*january 16 2024 */
  package com.teambcmsproject.teambcmsprojectspringboot.exception;

public class InstructorNotFoundException  extends RuntimeException {
    public InstructorNotFoundException(Long instructor_id){
        super("Could not found the course with id  " + instructor_id);
    }

}
  /*january 16 2024 */

