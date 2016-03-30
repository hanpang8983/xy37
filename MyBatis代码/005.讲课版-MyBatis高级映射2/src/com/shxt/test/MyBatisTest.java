package com.shxt.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.shxt.mapper.ClazzMapper;
import com.shxt.mapper.CourseMapper;
import com.shxt.mapper.StudentMapper;
import com.shxt.model.Clazz;
import com.shxt.model.Course;
import com.shxt.model.Student;
import com.shxt.utils.MyBatisUtils;

public class MyBatisTest {
	
	@Test
	public void 通过班级的主键信息获取拥有的学生_传统方式(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//代码
			Clazz clazz= sqlSession.getMapper(ClazzMapper.class).load(200);
			List<Student> studentList = sqlSession.getMapper(StudentMapper.class).listStudentByClassId(clazz.getClass_id());
			
			clazz.setStudentList(studentList);
			
			System.out.println(clazz);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 通过班级的主键信息获取拥有的学生_MyBatis_Select方式(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			Clazz clazz= sqlSession.getMapper(ClazzMapper.class).load_select(200);
			System.out.println(clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 通过班级的主键信息获取拥有的学生_N加1问题(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//代码
			List<Clazz> clazzList= sqlSession.getMapper(ClazzMapper.class).listAll();
			System.out.println(clazzList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 通过班级的主键信息获取拥有的学生_MyBatis_ResultMap方式_第一种(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//代码
			Clazz clazz= sqlSession.getMapper(ClazzMapper.class).loadResutMap01(200);
			System.out.println(clazz);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 通过班级的主键信息获取拥有的学生_MyBatis_ResultMap方式_第二种(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//代码
			//代码
			Clazz clazz= sqlSession.getMapper(ClazzMapper.class).loadResutMap02(200);
			System.out.println(clazz);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	
	@Test
	public void 提高效率_如果字段相同_使用别名方式解决(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//代码
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	//题目:已知条件学生ID为2，获取该学生信息，其中包含其课程信息
	//控制台输出的: 2 林冲  所选课程信息
	//Student 
	@Test
	public void 通过主键ID获取学生信息_其中包含课程信息(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//代码
			Student student = sqlSession.getMapper(StudentMapper.class).loadStudentAndCourses(2);
			
			System.out.println(student);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	
	
	@Test
	public void 通过课程ID获取课程信息_包含所选课程的学生信息(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			//代码
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 使用Map的形式把数据保存到中间表(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<>();
			map.put("student_id", 12);
			map.put("course_id", 1000);
			list.add(map);
			
			map = new HashMap<>();
			map.put("student_id", 12);
			map.put("course_id", 2000);
			list.add(map);
			
			map = new HashMap<>();
			map.put("student_id", 12);
			map.put("course_id", 3000);
			list.add(map);
			
			sqlSession.getMapper(CourseMapper.class).addList(list);
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 使用Map的形式把数据保存到中间表2(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			Map<String, Object> map = new HashMap<>();
			map.put("student_id", 12);
			map.put("coures", new Integer[]{1000,2000,3000});
			
		
			sqlSession.getMapper(CourseMapper.class).addMap(map);
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	
	@Test
	public void 使用对象的形式把数据保存到中间表(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			Student student = new Student();
			student.setStudent_id(12);
			List<Course> courseList = new ArrayList<>();
			Course c = new Course();
			c.setCourse_id(1000);
			courseList.add(c);
			c = new Course();
			c.setCourse_id(2000);
			courseList.add(c);
			c = new Course();
			c.setCourse_id(3000);
			courseList.add(c);
			
			
			student.setCourseList(courseList);
		
			sqlSession.getMapper(CourseMapper.class).addObject(student);
			
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
	}
	

}
