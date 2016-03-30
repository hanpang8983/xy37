package com.shxt.mapper;

import java.util.List;
import java.util.Map;

import com.shxt.model.User;

public interface UserMapper {
	
	public User load01(Integer user_id);
	
	public User load02(Integer user_id);
	
	public User load03(Integer user_id);
	
	public void add(User user);
	
	public void update(User user);
}
