package com.durgesh.service;

import java.util.List;

import com.durgesh.model.Course;
import com.durgesh.model.User;

public interface IUserService {
	
	User saveUser(User user);
	List<Course> getByTechnology(String technology);
	List<Course> getAllCourse();
	void deleteByCourseName(String courseName);

	List<Course> getByDurationRange(String technology,Double courseDuration);
	 
	 

}
