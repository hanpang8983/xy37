package com.shxt.dao;

import com.shxt.model.User;

public interface UserDao {
	/**
	 * 通过主键获取用户对象
	 * @param user_id
	 * @return
	 */
	public User getUserByPK(Integer user_id);

}
