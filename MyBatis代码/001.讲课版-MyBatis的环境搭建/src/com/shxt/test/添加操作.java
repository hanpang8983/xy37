package com.shxt.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.shxt.model.User;

public class 添加操作 {

	public static void main(String[] args) {
		//1.读取核心配置文件
		String path = "mybatis-config.xml";
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream(path);
			//2.创建SqlSessionFactory工厂  相当于 Connection
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//3.创建SqlSession 相当于 Statement对象
			sqlSession = sqlSessionFactory.openSession();
			
			User user = new User();
			user.setAccount("songjaing");
			user.setPwd("123");
			user.setUserName("宋江");
			
			//4.执行定制的SQL语句
			sqlSession.insert("shxt.xy37.add", user);//namspace+"."+id
			//默认情况下所有的持久层框架的事务是手动提交
			
			//5.事务提交  -什么时候使用事务提交？ CUD操作
			sqlSession.commit();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null)sqlSession.close();
		}

	}

}
