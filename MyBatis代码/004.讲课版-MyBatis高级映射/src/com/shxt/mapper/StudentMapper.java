package com.shxt.mapper;

import java.util.List;

import com.shxt.model.Student;

public interface StudentMapper {

	public Student load(Integer student_id);
	
	public Student load_mybatis(Integer student_id);
	public List<Student> list();
	
	public Student load_resultMap(Integer student_id);

}
