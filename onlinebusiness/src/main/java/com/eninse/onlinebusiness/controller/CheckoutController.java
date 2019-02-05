package com.eninse.onlinebusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eninse.onlinebusiness.service.CartService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/review")
	public ModelAndView reviewCart() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("tittle", "Review Cart User");
		mv.addObject("userClickReviewCart", true);
		mv.addObject("cartLines", cartService.getListCartLine());
		
		return mv;
	}
}
