package com.shxt.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.shxt.mapper.UserMapper;
import com.shxt.model.User;
import com.shxt.utils.MyBatisUtils;



public class MyTest {
	@Test
	public void 初始学习(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			User user = sqlSession.getMapper(UserMapper.class).load01(6);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void ResultMap标签映射(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			User user = sqlSession.getMapper(UserMapper.class).load01(513);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void 添加操作(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			User user = new User();
			user.setAccount("xiaolin");
			user.setUserName("小林");
			user.setPwd("123456");
			//user.setStart_date(new Date());
			//user.setEnd_date(new Date());
			
			sqlSession.getMapper(UserMapper.class).add(user);
			
			System.out.println(user.getUserId());
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void 时间戳() throws ParseException{
		String str = "2016-03-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		System.out.println(date.getTime());
	}
	

}
