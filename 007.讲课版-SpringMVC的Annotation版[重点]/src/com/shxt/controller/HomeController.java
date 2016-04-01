package com.shxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shxt/user")
public class HomeController {
	
	@RequestMapping(value="/xy37",method=RequestMethod.GET)
	public ModelAndView test01(){
		System.out.println("================");
		return null;
	}
	
	@RequestMapping(value="/xy37",method=RequestMethod.POST)
	public ModelAndView test02(){
		System.out.println("**********");
		return null;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView test03(){
		System.out.println("**********");
		return null;
	}
}
