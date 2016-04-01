package com.shxt.mapper;

import java.util.List;
import java.util.Map;

import com.shxt.model.User;

public interface UserMapper {
	
	public User load(Integer user_id);
	
	public List<User> listByNameStatus01(Map<String,Object> map);
	
	public List<User> listByNameStatus02(String shxtName,String status );
	
	public List<User> listByNameStatus03(Map<String,Object> userNameMap,Map<String,Object> statusMap);
	
	
	public List<User> where01(Map<String,Object> map);
	public List<User> where02(Map<String,Object> map);
	public List<User> where03(Map<String,Object> map);
	
	public void update01(User user);

	public void add(User user);
	
	public List<User> listByIds01(List<Integer> ids);
	public List<User> listByIds02(Integer[] ids);

}
