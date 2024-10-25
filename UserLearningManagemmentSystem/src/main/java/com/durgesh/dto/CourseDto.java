package com.durgesh.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@ToString
public class CourseDto {
	
	private Integer courseId;
	
	@NotEmpty
	@Size(min = 20, message = "Course name should have at least 20 characters")
	private String courseName;
	
	@NotNull(message = "Please provide a courseDuration")
	private Double courseDuration;
	
	
	@NotEmpty
	@Size(min = 50, message = "CourseDescription should have at least 50 characters")
	private String courseDescription;
	
	@NotEmpty(message = "Please provide a technology")
	private String technology;
	
	@NotEmpty(message = "Please provide a launchUrl")
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

	public CourseDto(Integer courseId,
			@NotEmpty @Size(min = 20, message = "Course name should have at least 20 characters") String courseName,
			@NotNull(message = "Please provide a courseDuration") Double courseDuration,
			@NotEmpty @Size(min = 50, message = "CourseDescription should have at least 50 characters") String courseDescription,
			@NotEmpty(message = "Please provide a technology") String technology,
			@NotEmpty(message = "Please provide a launchUrl") String launchUrl) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseDescription = courseDescription;
		this.technology = technology;
		this.launchUrl = launchUrl;
	}
	
	

}
