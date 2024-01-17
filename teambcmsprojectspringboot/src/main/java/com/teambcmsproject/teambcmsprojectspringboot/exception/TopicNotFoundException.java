  /*january 16 2024 */

package com.teambcmsproject.teambcmsprojectspringboot.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(Long topic_id){
        super("Could not found the topic with id  " + topic_id);
    }

}
  /*january 16 2024 */
