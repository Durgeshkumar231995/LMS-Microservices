package com.durgesh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.exception.CourseDurationNotFoundException;
import com.durgesh.exception.CourseNameNotFoundException;
import com.durgesh.exception.TechnologyNotFoundException;
import com.durgesh.model.Course;
import com.durgesh.model.User;
import com.durgesh.repository.CourseRepository;
import com.durgesh.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	
	@Override
	public List<Course> getByTechnology(String technology) {
		
			List<Course> course = courseRepository.findByTechnology(technology);
			if(course.isEmpty()) {
				throw new TechnologyNotFoundException("technolog not found with : "+ technology);
			}
			
			return course;
		
	}

	@Override
	public List<Course> getAllCourse() {
		
		return courseRepository.findAll();
	}

	@Override
	public void deleteByCourseName(String courseName) {
		List<Course> CourseName = courseRepository.findByCourseName(courseName);
		
		if(CourseName.isEmpty()) {
			throw new  CourseNameNotFoundException(" CourseName not found with : "+ courseName);
		}else {
			courseRepository.deleteByCourseName(courseName);
			
		}
		
	}

	@Override
	public List<Course> getByDurationRange(String technology,Double courseDuration) {
		List<Course> durationRange = courseRepository.findByDurationRange(technology, courseDuration);
		if(durationRange.isEmpty()) {
			throw new  CourseDurationNotFoundException(" CourseDuration not found");
		}
		
		return durationRange;
	}

	

}
