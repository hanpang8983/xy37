package com.shxt.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.shxt.dao.UserDao;
import com.shxt.model.User;
import com.shxt.utils.MyBatisUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByPK(Integer user_id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//SQLID
			return  sqlSession.selectOne(User.class.getName()+".load", user_id);//namespace+"."id的方式就是SQLID的方式
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		return null;
	}

}
