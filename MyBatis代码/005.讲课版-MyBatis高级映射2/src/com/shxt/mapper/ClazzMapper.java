package com.shxt.mapper;

import java.util.List;

import com.shxt.model.Clazz;

public interface ClazzMapper {
	
	public Clazz load(Integer class_id);
	
	public Clazz load_select(Integer class_id);
	
	
	public List<Clazz> listAll();
	
	public Clazz loadResutMap01(Integer class_id);
	
	public Clazz loadResutMap02(Integer class_id);
	

}
