  /*january 16 2024 */

package com.teambcmsproject.teambcmsprojectspringboot.exception;

public class ChapterNotFoundException extends RuntimeException {
    public ChapterNotFoundException(Long chapter_id){
        super("Could not found the course with id  " + chapter_id);
    }

}
  /*january 16 2024 */
