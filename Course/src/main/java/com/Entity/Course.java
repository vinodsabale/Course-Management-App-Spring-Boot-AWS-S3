package com.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
 

@Entity
@Table(name="course")

@Builder
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String courseName;
	@Column(nullable=false)
	private String courseDuration;
	@Column(nullable=false)
	private Double coursePrice;
	//se img url be sotred here
	@Column(length=1000)
	private String courseImageUrl;
	public Course(){}
	public Course(Long id, String courseName, String courseDuration, Double coursePrice, String courseImageUrl) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.coursePrice = coursePrice;
		this.courseImageUrl = courseImageUrl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	public Double getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Double coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getCourseImageUrl() {
		return courseImageUrl;
	}
	public void setCourseImageUrl(String courseImageUrl) {
		this.courseImageUrl = courseImageUrl;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", coursePrice=" + coursePrice + ", courseImageUrl=" + courseImageUrl + "]";
	}
	
	
}
