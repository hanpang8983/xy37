package com.shxt.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * MyBatis工具类的封装
 * @author 刘文铭
 *
 */
public class MyBatisUtils {
	private MyBatisUtils(){}//不能对MyBatisUtils工具类进行实例化
	
	private static SqlSessionFactory sqlSessionFactory = null;
	private static final String PATH = "mybatis-config.xml";//常量信息
	private static InputStream inputStream = null;
	static{//静态代码块
		try {
			inputStream = Resources.getResourceAsStream(PATH);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("加载MyBatis的核心配置文件出错，异常为:"+e.getMessage());
		}
	}
	/**
	 * 获取SqlSession
	 * @return
	 */
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
	/**
	 * 关闭SqlSession
	 * @param sqlSession
	 */
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null)sqlSession.close();
	}

}
