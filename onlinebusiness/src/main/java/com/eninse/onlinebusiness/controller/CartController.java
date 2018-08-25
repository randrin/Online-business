package com.eninse.onlinebusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eninse.onlinebusiness.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/show")
	public ModelAndView showCart() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("tittle", "Cart User");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getListCartLine());
		return mv;
	}
}
