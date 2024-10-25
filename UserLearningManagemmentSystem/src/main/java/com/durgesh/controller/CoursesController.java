package com.durgesh.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.dto.CourseDto;
import com.durgesh.model.Course;
import com.durgesh.service.IUserService;

@RestController
@RequestMapping("/api/v1.0/lms/courses")
@CrossOrigin("http://localhost:4200/")
public class CoursesController {
	Logger logger = LoggerFactory.getLogger( CoursesController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Zuul call url
	//http://ctsjava1373.iiht.tech:8787/learning-management-system-user/api/v1.0/lms/courses/info/C++
	
	@GetMapping("/info/{technology}")
	public ResponseEntity<List<CourseDto>> getCourseByTech(@PathVariable(name = "technology") String technology) {
		
		logger.info("name of technology is "+technology);
		
		List<CourseDto> allTechnology = userService.getByTechnology(technology)
		.stream().map(course->modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
		
		logger.info("Retrieve technology is "+allTechnology);
		
		
		return new ResponseEntity<>(allTechnology,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CourseDto>> getAllCourse(){
		
		List<CourseDto> allCourse = userService.getAllCourse().stream().map(course->modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
		
		logger.info("all Course is "+allCourse);
		return new ResponseEntity<>(allCourse,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{courseName}")
	public ResponseEntity<String> deleteCourseByCourseName(@PathVariable(name = "courseName") String courseName) {
		
		logger.info("Course name send to delete is  "+courseName);
		
		userService.deleteByCourseName(courseName);
		
		return new ResponseEntity<>("deleted "+courseName,HttpStatus.OK);
		
	}
	
	@GetMapping("/getBy/{technology}/{courseDuration}")
	public ResponseEntity<List<Course>> getByDurationRange(@PathVariable("technology")String technology,@PathVariable("courseDuration")Double courseDuration) {
		
		logger.info("technology name given by user is   "+technology +" & courseDuration is "+courseDuration);
		List<Course> courseList = userService.getByDurationRange(technology, courseDuration);
		
		logger.info("Retrive  Courses list  is "+courseList);
		
		return new ResponseEntity<>(courseList,HttpStatus.OK);
		
	}
	
	
	

}
