//January 22 2024 data transfer object

package com.teambcmsproject.teambcmsprojectspringboot.DTO;

public class TopicDTO {
    private Long topic_id;
    private String topic_title;
    private String topic_description;
    private String topic_file;
    private String topic_link;
    private String chapter_title;


    public Long getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_title() {
        return this.topic_title;
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title;
    }

    public String getTopic_description() {
        return this.topic_description;
    }

    public void setTopic_description(String topic_description) {
        this.topic_description = topic_description;
    }

    public String getTopic_file() {
        return this.topic_file;
    }

    public void setTopic_file(String topic_file) {
        this.topic_file = topic_file;
    }

    public String getTopic_link() {
        return this.topic_link;
    }

    public void setTopic_link(String topic_link) {
        this.topic_link = topic_link;
    }

    public String getChapter_title() {
        return this.chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

}
//January 22 2024 data transfer object
