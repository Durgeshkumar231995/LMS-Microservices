package com.durgesh.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.dto.CourseDto;
import com.durgesh.model.Course;
import com.durgesh.service.ICourseService;

@RestController
@RequestMapping("/api/v1.0/lms/Course")
public class AdminCourseController {
	
	// zull api call url
	
	// http://ctsjava1373.iiht.tech:8787/learning-management-system-admin/api/v1.0/lms/Course/AllCourse
	@Autowired
	private ICourseService iCourseService ;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//http://localhost:8090/swagger-ui/index.html
	@PostMapping("/saveCourse")
	public ResponseEntity<CourseDto> addCourse(@Valid @RequestBody CourseDto courseDto){
		
				// convert DTO to entity
				Course course = modelMapper.map(courseDto, Course.class);
				Course saveCourse = iCourseService.saveCourse(course);

				// convert entity to DTO
				CourseDto saveCourseDto = modelMapper.map(saveCourse, CourseDto.class);
		
		return new ResponseEntity<>(saveCourseDto,HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/AllCourse")
	public ResponseEntity<List<CourseDto>> getAllCourse(){
		
		List<CourseDto> allCourse = iCourseService.getAllCourse().stream().map(course->modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
		
		return new ResponseEntity<>(allCourse,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateCourse/{id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable Integer id, @RequestBody CourseDto courseDto) {
		
		Course course = modelMapper.map(courseDto,Course.class);
		Course updateCourse = iCourseService.updateCourse(id, course);
		CourseDto updatedCourse = modelMapper.map(updateCourse,CourseDto.class);
		
		return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/CourseBy/{id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable(name = "id") Integer id) {
		
		Course existingCourse = iCourseService.getCourseById(id);
		
		CourseDto course = modelMapper.map(existingCourse,CourseDto.class);
		return new ResponseEntity<>(course,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/DeleteCourseBy/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable(name = "id") Integer id) {
		
		 iCourseService.deleteCourse(id);
		
		
		return new ResponseEntity<>("Course deleted successfully with id :"+id,HttpStatus.OK);
		
	}
	
	@GetMapping("/getCourseByTechnology/{technology}")
	public ResponseEntity<List<CourseDto>> getCourseByTech(@PathVariable(name = "technology") String technology) {
		
	
		
		List<CourseDto> allTechnology = iCourseService.getByTechnology(technology).stream().map(course->modelMapper.map(course,CourseDto.class)).collect(Collectors.toList());
		
		
		return new ResponseEntity<List<CourseDto>>(allTechnology,HttpStatus.OK);
		
	}
	
	
}
