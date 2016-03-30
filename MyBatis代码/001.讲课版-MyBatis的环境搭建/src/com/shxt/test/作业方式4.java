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
import com.shxt.utils.MyBatisUtils;

public class 作业方式4 {

	public static void main(String[] args) {
		
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtils.getSqlSession();
			
			sqlSession.selectList("shxt.xy37.list", null);
			
		}finally{
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		
		
	}

}
