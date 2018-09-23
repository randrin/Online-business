package com.eninse.onlinebusiness.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eninse.businessbackend.dao.CartLineDAO;
import com.eninse.businessbackend.dao.ProductDAO;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.onlinebusiness.model.ProfileUserModel;

@Service("checkoutService")
public class CheckoutService {

	private Logger log = LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	 @Autowired
	 private HttpSession session;
	 
	 /*
	  * Method to retrieve items cart user logged
	  */
	 private Cart getCart(){
		 log.info("Retrieving item cart to user logged ....");
		 return ((ProfileUserModel) session.getAttribute("profileUserModel")).getCart();
	 }
}
