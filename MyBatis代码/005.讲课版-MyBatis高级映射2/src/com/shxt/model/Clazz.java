package com.shxt.model;

import java.util.List;

public class Clazz {
	
	private Integer class_id;
	private String class_name;
	
	private List<Student> studentList;
	
	
	
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	@Override
	public String toString() {
		return "Clazz [class_id=" + class_id + ", class_name=" + class_name + ", studentList=" + studentList + "]";
	}
	
	

}
