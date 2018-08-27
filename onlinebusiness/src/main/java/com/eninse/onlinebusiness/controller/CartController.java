package com.eninse.onlinebusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eninse.onlinebusiness.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/show")
	public ModelAndView showCart(@RequestParam(name= "result", required=false) String result) {
		
		ModelAndView mv = new ModelAndView("page");
		
		if (result != null){
			switch (result) {
				case "update":
					mv.addObject("message", "CartLine updated successfully");
					break;

				case "error":
					mv.addObject("message", "There are something wrong! Try again");
					break;
				default:
					break;
			}
		}
		
		mv.addObject("tittle", "Cart User");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getListCartLine());
		return mv;
	}
	
	@RequestMapping(value="/{cartId}/update")
	public String cartUpdateproduct(@PathVariable int cartId, @RequestParam int count) {
		
		String response = cartService.updteCartLineUser(cartId, count);
		
		return "redirect:/cart/show?" +response;
	}
}
