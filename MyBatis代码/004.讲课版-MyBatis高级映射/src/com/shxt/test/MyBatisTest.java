package com.shxt.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.shxt.mapper.ClazzMapper;
import com.shxt.mapper.StudentMapper;
import com.shxt.model.Clazz;
import com.shxt.model.Student;
import com.shxt.utils.MyBatisUtils;

public class MyBatisTest {
	
	@Test
	public void 主键加载数据(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			Student s = sqlSession.getMapper(StudentMapper.class).load(1);
			//通过学生的ID要获取所属的班级
			Clazz c = sqlSession.getMapper(ClazzMapper.class).load(s.getFk_class_id());
			
			s.setClazz(c);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void mybatis_select的方式(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			Student s = sqlSession.getMapper(StudentMapper.class).load_mybatis(2);
		
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 获取所有的学生信息和对应的班级(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			sqlSession.getMapper(StudentMapper.class).list();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void resultMap方式(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			Student s = sqlSession.getMapper(StudentMapper.class).load_resultMap(2);
		
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	
}
