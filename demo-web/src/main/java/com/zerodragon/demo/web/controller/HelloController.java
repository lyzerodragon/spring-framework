package com.zerodragon.demo.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author : zero dragon
 * @version : 1.0
 * @date : 2023/3/19-20:23
 **/
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		ModelAndView v = new ModelAndView();
		v.addObject("name",name);
		v.setViewName("hello");
		return v;
	}
}