package com.shxt.mapper;

import java.util.List;

import com.shxt.model.Student;

public interface StudentMapper {
	
	List<Student> listStudentByClassId(Integer class_id);
	
	Student loadStudentAndCourses(Integer student_id);
   
}