package com.eninse.onlinebusiness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Online Business project");
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="test", required=false)String test) {
		ModelAndView mv = new ModelAndView("page");
		if (test == null) {
			test = "Hello user";
		}
		mv.addObject("greeting", test);
		return mv;
	}
	
	@RequestMapping(value="/test/{test}")
	public ModelAndView testPath(@PathVariable("test")String test) {
		ModelAndView mv = new ModelAndView("page");
		if (test == null) {
			test = "Hello user";
		}
		mv.addObject("greeting", test);
		return mv;
	}
}
