package com.durgesh.util;

import com.durgesh.dto.CourseDto;
import com.durgesh.model.Course;

public class EntityConversion {
	
	public CourseDto mapToDTO(Course course) {
		
		CourseDto courseDto=new CourseDto();
		
		courseDto.setCourseId(course.getCourseId());
		courseDto.setCourseName(course.getCourseName());
		courseDto.setCourseDuration(course.getCourseDuration());
		courseDto.setCourseDescription(course.getCourseDescription());
		
		courseDto.setTechnology(course.getTechnology());
		courseDto.setLaunchUrl(course.getLaunchUrl());
		
		return courseDto;
	
	}
	
	
public Course mapToModel(CourseDto courseDto) {
		
		Course course=new Course();
		
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		course.setCourseDuration(courseDto.getCourseDuration());
		course.setCourseDescription(courseDto.getCourseDescription());
		
		course.setTechnology(courseDto.getTechnology());
		course.setLaunchUrl(courseDto.getLaunchUrl());
		
		return course;
	
	}


}
