package com.durgesh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	List<Course> findByTechnology(String technology);
	

}
