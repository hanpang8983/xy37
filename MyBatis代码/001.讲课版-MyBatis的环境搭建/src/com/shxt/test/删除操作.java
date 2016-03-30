package com.shxt.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.shxt.model.User;

public class 删除操作 {

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
			
			//4.执行定制的SQL语句
			sqlSession.delete("shxt.xy37.delete", 501);
			
			//5.事务提交  -什么时候使用事务提交？ CUD操作
			sqlSession.commit();
		
		} catch (Exception e) {
			//6.如果对数据CUD操作的时候，需要经过回滚
			if(sqlSession!=null)sqlSession.rollback();
			e.printStackTrace();
		}finally {
			//7.关闭资源
			if(sqlSession!=null)sqlSession.close();
		}

	}

}
