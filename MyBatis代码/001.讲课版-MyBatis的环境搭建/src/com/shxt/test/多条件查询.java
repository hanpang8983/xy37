package com.shxt.test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.shxt.model.User;

public class 多条件查询 {

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
			Map<String,Object> map = new HashMap<>();
			map.put("shxt", "林");
			map.put("status", "1");
			
			//List<User> userList = sqlSession.selectList("shxt.xy37.list");
			//List<User> userList = sqlSession.selectList("shxt.xy37.listByStatusName01",map);
			List<Map<String,Object>> dataList = sqlSession.selectList("shxt.xy37.listByStatusName02",map);
		System.out.println(dataList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null)sqlSession.close();
		}

	}

}
