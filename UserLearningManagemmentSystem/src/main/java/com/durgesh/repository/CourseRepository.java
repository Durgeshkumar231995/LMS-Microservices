package com.durgesh.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.durgesh.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	List<Course> findByTechnology(String technology);
	
	@Modifying
	@Transactional
    @Query("delete from Course c where c.courseName = :courseName")
    void deleteByCourseName(String courseName);
	
	List<Course> findByCourseName(String courseName);
	

	
	@Query("SELECT c FROM Course c WHERE c.technology LIKE %:technology% or c.courseDuration =:courseDuration ")
	List<Course> findByDurationRange(@Param("technology")String technology,@Param("courseDuration")Double courseDuration);
	

}
