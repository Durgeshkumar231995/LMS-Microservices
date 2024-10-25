package com.durgesh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@Entity

@ToString
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

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(Double courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getLaunchUrl() {
		return launchUrl;
	}

	public void setLaunchUrl(String launchUrl) {
		this.launchUrl = launchUrl;
	}

	public Course(Integer courseId, String courseName, Double courseDuration, String courseDescription,
			String technology, String launchUrl) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseDescription = courseDescription;
		this.technology = technology;
		this.launchUrl = launchUrl;
	}
	
	
	
	
	
}
