package com.shxt.mapper;

import java.util.List;
import java.util.Map;

import com.shxt.model.Student;

public interface CourseMapper {
	
	void addList(List<Map<String,Object>> dataList);
	
	void addMap(Map<String,Object> map);
	
	void addObject(Student student);
    
}