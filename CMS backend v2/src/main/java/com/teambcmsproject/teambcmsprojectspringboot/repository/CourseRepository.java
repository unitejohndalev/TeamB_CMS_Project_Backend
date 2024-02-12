    //january 13 2024
    package com.teambcmsproject.teambcmsprojectspringboot.repository;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import com.teambcmsproject.teambcmsprojectspringboot.model.Course;

    public interface CourseRepository extends JpaRepository<Course, Long> {

        List<Course> findAll();

        Optional<Course> findById(Long course_id);


    @Query("SELECT DISTINCT c FROM Course c JOIN c.chapter ch WHERE ch.chapter_id = :chapter_id")
    List<Course> findByChapterId(@Param("chapter_id") Long chapter_id);
}

    // january 13 2024