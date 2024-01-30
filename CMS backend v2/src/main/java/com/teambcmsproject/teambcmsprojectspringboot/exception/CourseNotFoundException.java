  /*january 16 2024 */

package com.teambcmsproject.teambcmsprojectspringboot.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long course_id){
        super("Could not found the course with id  " + course_id);
    }



}
  /*january 16 2024 */
