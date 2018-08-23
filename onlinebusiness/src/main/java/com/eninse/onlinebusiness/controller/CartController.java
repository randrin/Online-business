package com.eninse.onlinebusiness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping(value="/show")
	public ModelAndView showCart() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("tittle", "Cart User");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", null);
		return mv;
	}
}
