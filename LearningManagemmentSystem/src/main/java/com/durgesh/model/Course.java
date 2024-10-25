package com.durgesh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	@Id
	@GeneratedValue
	private Integer courseId;
	
//	@NotEmpty
//	@Size(min = 20, message = "Course name should have at least 20 characters")
	private String courseName;
	
	//@NotNull(message = "Please provide a courseDuration")
	private Double courseDuration;
	
//	@NotEmpty
//	@Size(min = 50, message = "CourseDescription should have at least 50 characters")
	private String courseDescription;
	
	//@NotEmpty(message = "Please provide a technology")
	private String technology;
	
	//@NotEmpty(message = "Please provide a launchUrl")
	private String launchUrl;
}
