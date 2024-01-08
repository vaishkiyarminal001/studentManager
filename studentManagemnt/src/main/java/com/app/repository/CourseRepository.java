package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	 @Query("SELECT c FROM Course c WHERE LOWER(c.courseName) LIKE LOWER(CONCAT('%', :courseOrTopic, '%')) OR LOWER(c.description) LIKE LOWER(CONCAT('%', :courseOrTopic, '%'))")
	    List<Course> findByCourseName(@Param("courseOrTopic") String courseOrTopic);
}
