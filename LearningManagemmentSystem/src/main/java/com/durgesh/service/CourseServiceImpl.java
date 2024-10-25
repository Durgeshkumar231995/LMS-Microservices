package com.durgesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.exception.CourseNotFoundException;
import com.durgesh.exception.ResourceNotFoundException;
import com.durgesh.exception.TechnologyNotFoundException;
import com.durgesh.model.Course;
import com.durgesh.repository.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository  courseRepository;

	@Override
	public Course saveCourse(Course course) {
		
		return  courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourse() {
		
		return courseRepository.findAll();
	}

	@Override
	public Course updateCourse(Integer id,Course course) {
		
		Course courseId=courseRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Course not found with id : "+ id));
		
		courseId.setCourseName(course.getCourseName());
		courseId.setCourseDuration(course.getCourseDuration());
		courseId.setCourseDescription(course.getCourseDescription());
		courseId.setTechnology(course.getTechnology());
		courseId.setLaunchUrl(course.getLaunchUrl());

		
		return courseRepository.save(courseId);
	}

	@Override
	public Course getCourseById(Integer id) {
		Optional<Course> ExistingCourseId = courseRepository.findById(id);
		if(ExistingCourseId.isPresent()) {
			return ExistingCourseId.get();
		}else {
			throw new CourseNotFoundException("Course not found with id : "+ id);
		}
		
	}

	@Override
	public void deleteCourse(Integer id) {
		Course courseId=courseRepository.findById(id).orElseThrow(() ->new CourseNotFoundException("Course not found with id : "+ id));
		courseRepository.delete(courseId);
	}

	@Override
	public List<Course> getByTechnology(String technology) {
		
		
		try {
			List<Course> course = courseRepository.findByTechnology(technology);
			
			if(course.isEmpty()) {
				throw new TechnologyNotFoundException("technolog not found with : "+ technology);
			}
			
			return course;
			
		} catch (Exception e) {
		
			throw new TechnologyNotFoundException("technolog not found with : "+ technology);
		}
	}
	
	
	
	

}
