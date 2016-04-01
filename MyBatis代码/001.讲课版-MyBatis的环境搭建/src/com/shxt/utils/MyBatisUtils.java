package com.shxt.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 封装MyBatisUtils工具类
 * @author 刘文铭
 *
 */
public class MyBatisUtils {
	private MyBatisUtils(){}//该类不能被实例化
	private static SqlSessionFactory sqlSessionFactory = null;
	private static final String PATH="mybatis-config.xml";
	private static InputStream inputStream = null;
	static{//static什么特点？？？？？
		try {
			inputStream = Resources.getResourceAsStream(PATH);//加载核心配置文件
			//创建SqlSessionFactory工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println("加载MyBatis核心配置文件错误，异常信息为:"+e.getMessage());
		}
	}
	/**
	 * 描述:获取SqlSession对象
	 * @return
	 */
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
	/**
	 * 描述:关闭SqlSession对象
	 */
	public static void closeSqlSession(SqlSession sqlSession){
		if(sqlSession!=null)sqlSession.close();
	}

}
