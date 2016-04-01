package com.shxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class IndexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("=============");
		
		ModelAndView mav = new ModelAndView();
		//InternalResourceViewResolver.REDIRECT_URL_PREFIX 重定向的配置
		
		// 默认值:InternalResourceViewResolver.FORWARD_URL_PREFIX 请求转发
		
		mav.setViewName(InternalResourceViewResolver.REDIRECT_URL_PREFIX +"shxt.jsp");//prefix+"home"+suffix
		
		return mav;
	}

}
