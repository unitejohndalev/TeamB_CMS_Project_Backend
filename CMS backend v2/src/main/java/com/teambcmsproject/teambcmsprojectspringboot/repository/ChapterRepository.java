package com.teambcmsproject.teambcmsprojectspringboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.teambcmsproject.teambcmsprojectspringboot.model.Chapter;
import com.teambcmsproject.teambcmsprojectspringboot.model.Course;


public interface ChapterRepository extends JpaRepository<Chapter, Long>  {
  
    List<Chapter> findAll();

    Optional<Chapter> findById(Long chapter_id);

    // @Query("Select ch FROM Chapter ch WHERE ch.course.course_id = :course_id")
    // List<Chapter> findByCourseId(@Param("course_id") Long course_id);

}
