package com.eninse.onlinebusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eninse.businessbackend.dao.CategoryDAO;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categorydao;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categorydao", categorydao.listCategory());
		mv.addObject("tittle", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/services")
	public ModelAndView services() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "Services");
		mv.addObject("userClickServices", true);
		return mv;
	}
	
	@RequestMapping(value = "/listProducts")
	public ModelAndView listproducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "List of Products");
		mv.addObject("userClickListProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "Contact Us");
		mv.addObject("userClickContact", true);
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
