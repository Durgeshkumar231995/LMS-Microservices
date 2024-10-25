package com.durgesh.service;

import java.util.List;

import com.durgesh.model.Course;

public interface ICourseService {
	
	Course saveCourse(Course course);
	
	List<Course> getAllCourse();
	
	Course updateCourse(Integer id,Course course);
	
	Course getCourseById(Integer id);
	
	void deleteCourse(Integer id);
	
	List<Course>getByTechnology(String technology);

}
