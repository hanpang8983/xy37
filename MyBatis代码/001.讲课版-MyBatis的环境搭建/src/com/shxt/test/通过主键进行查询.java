package com.shxt.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.shxt.model.User;

public class 通过主键进行查询 {

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
			
			
			User user = sqlSession.selectOne("shxt.xy37.load", 7);
			System.out.println(user);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null)sqlSession.close();
		}

	}

}
