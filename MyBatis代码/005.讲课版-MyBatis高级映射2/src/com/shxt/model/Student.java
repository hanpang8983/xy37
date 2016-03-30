package com.shxt.model;

import java.util.List;

public class Student {
	
	private Integer student_id;
	private String student_name;
	private Integer fk_class_id;
	
	private List<Course> courseList;
	
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getFk_class_id() {
		return fk_class_id;
	}
	public void setFk_class_id(Integer fk_class_id) {
		this.fk_class_id = fk_class_id;
	}
	
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", fk_class_id=" + fk_class_id
				+ ", courseList=" + courseList + "]";
	}
	
	
	

}
