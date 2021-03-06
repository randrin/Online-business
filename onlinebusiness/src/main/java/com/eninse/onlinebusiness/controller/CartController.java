package com.eninse.onlinebusiness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eninse.onlinebusiness.constants.AlertMessagesConstants;
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
				case "added":
					mv.addObject("message", AlertMessagesConstants.ALERT_ADD_PRODUCT);
					break;
				case "update":
					mv.addObject("message", AlertMessagesConstants.ALERT_UPDATE_PRODUCT);
					break;
				case "delete":
					mv.addObject("message", AlertMessagesConstants.ALERT_REMOVE_PRODUCT);
					break;
				case "error":
					mv.addObject("message", AlertMessagesConstants.ALERT_ERROR_ACTION);
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
	public String cartUpdateProduct(@PathVariable int cartId, @RequestParam int count) {
		
		String response = cartService.updateCartLineUser(cartId, count);
		
		return "redirect:/cart/show?" +response;
	}
	
	@RequestMapping(value="/{cartId}/delete")
	public String cartDeleteProduct(@PathVariable int cartId) {
		
		String response = cartService.deleteCartLineUser(cartId);
		
		return "redirect:/cart/show?" +response;
	}
	
	@RequestMapping(value="/add/{productId}/product")
	public String addProduct(@PathVariable int productId) {
		
		String response = cartService.addCartLineUser(productId);
		
		return "redirect:/cart/show?" +response;
	}
}
