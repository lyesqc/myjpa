package org.me.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvisor {
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView HandelMe(HttpServletRequest req,Exception ex){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception",ex);
		mv.setViewName("exception");
		return mv;
	}

}
