package com.eninse.onlinebusiness.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class DataUserController {

	private static final Logger log =  LoggerFactory.getLogger(DataUserController.class);
	
	@RequestMapping(value = "/orders")
	public ModelAndView dataUserOrders() {
		log.debug("Init Section dataUserOrders controller ...");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "My Orders");
		mv.addObject("userClickOrders", true);
		return mv;
	}
	
	@RequestMapping(value = "/advantages")
	public ModelAndView dataUserAdvantages() {
		log.debug("Init Section dataUserAdvantages controller ...");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "My Advantages");
		mv.addObject("userClickProfile", true);
		return mv;
	}
	
	@RequestMapping(value = "/userInformations")
	public ModelAndView dataUserInformations() {
		log.debug("Init Section dataUserInformations controller ...");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "My Data Informations");
		mv.addObject("userClickProfile", true);
		return mv;
	}
	
	@RequestMapping(value = "/setting")
	public ModelAndView dataUserSetting() {
		log.debug("Init Section dataUserSetting controller ...");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("tittle", "My Settings");
		mv.addObject("userClickSettings", true);
		return mv;
	}
}
