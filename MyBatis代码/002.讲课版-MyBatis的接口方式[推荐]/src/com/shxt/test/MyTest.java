package com.shxt.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.shxt.dao.UserDao;
import com.shxt.dao.impl.UserDaoImpl;
import com.shxt.mapper.UserMapper;
import com.shxt.model.User;
import com.shxt.utils.MyBatisUtils;



public class MyTest {
	@Test
	public void SQLID的方式(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//SQLID
			User user = sqlSession.selectOne(User.class.getName()+".load", 3);//namespace+"."id的方式就是SQLID的方式
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	@Test
	public void 通过SQLID的方式模拟接口方式(){
		UserDao userDao = new UserDaoImpl();//接口回调
		
		User user = userDao.getUserByPK(3);
		//断言
		Assert.assertEquals("林彪132", user.getUserName());
	}
	
	@Test
	public void MyBatis的接口方式(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			sqlSession.getMapper(UserMapper.class).load(3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void 使用Map传递多个参数_推荐的方式(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("user_name", "林");
			map.put("status", "1");
			
			sqlSession.getMapper(UserMapper.class).listByNameStatus01(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	
	@Test
	public void 使用接口方式在形参中传递多个参数(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.getMapper(UserMapper.class).listByNameStatus02("林", "1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void 使用接口方式在形参中传递多个参数_复杂的(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			sqlSession.getMapper(UserMapper.class).listByNameStatus02("林", "1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void Where语句的测试(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			Map<String, Object> map = new HashMap<>();
			map.put("userName", "");
			map.put("status", "");
			
			sqlSession.getMapper(UserMapper.class).where01(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	@Test
	public void Where语句的测试02(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			Map<String, Object> map = new HashMap<>();
			map.put("userName", "");
			map.put("status", "");
			
			sqlSession.getMapper(UserMapper.class).where02(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void Where语句的测试03(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			Map<String, Object> map = new HashMap<>();
			map.put("userName", "林");
			map.put("status", "");
			
			sqlSession.getMapper(UserMapper.class).where03(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void 更新语句01(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			User user = new User();
			user.setUserId(3);
			user.setUserName("456");
			user.setPwd("123123");
			user.setAccount("232323");
			
			sqlSession.getMapper(UserMapper.class).update01(user);
			
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void 添加语句(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			User user = new User();
			user.setAccount("232323");
			
			sqlSession.getMapper(UserMapper.class).add(user);
			
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void foreach标签使用数组传递(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			List<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(2);
			list.add(3);
			
			sqlSession.getMapper(UserMapper.class).listByIds01(list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	@Test
	public void foreach标签使用数组传递02(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			Integer[] ids = new Integer[]{1,2};
			
			sqlSession.getMapper(UserMapper.class).listByIds02(ids);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
	}
	
	

}
