//january 17 2024
package com.teambcmsproject.teambcmsprojectspringboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.teambcmsproject.teambcmsprojectspringboot.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

   List<Topic> findAll();

   Optional<Topic> findById(Long topic_id);

   @Query("Select t FROM Topic t WHERE t.chapter.chapter_id = :chapter_id")
   List<Topic> findByChapter_id(@Param("chapter_id") Long chapter_id);

}
// january 13 2024