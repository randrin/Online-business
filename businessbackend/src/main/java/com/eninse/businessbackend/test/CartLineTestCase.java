package com.eninse.businessbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eninse.businessbackend.dao.CartLineDAO;
import com.eninse.businessbackend.dao.ProductDAO;
import com.eninse.businessbackend.dao.UserDAO;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.CartLine;
import com.eninse.businessbackend.dto.Product;
import com.eninse.businessbackend.dto.User;

public class CartLineTestCase {

	public static final Logger log = LoggerFactory.getLogger(CartLineTestCase.class);
	
	private static AnnotationConfigApplicationContext context;
	private CartLine cartLine;
	private static CartLineDAO cartLineDAO;
	private Product product;
	private static ProductDAO productDAO;
	private User user;
	private Cart cart;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.eninse.businessbackend");
		context.refresh();
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDCartLine() {
		
		user = userDAO.getByEmail("vtakou7@yahoo.fr");
		log.info("User Parameters: " +user.toString());
		
		cart = user.getCart();
		//log.info("Cart Parameters: " +cart.toString());
		//log.info("Cart Id: " +cart.getId());
		
		product = productDAO.get(1);
		
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(user.getId());
		cartLine.setProduct(product);
		assertEquals("Test add cartLIne Succeffully", true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setTotal(cart.getTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("Test update cartLine Succeffully", true, cartLineDAO.updateCart(cart));
	}
}
