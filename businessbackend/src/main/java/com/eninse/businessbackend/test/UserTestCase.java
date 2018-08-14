package com.eninse.businessbackend.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eninse.businessbackend.dao.UserDAO;
import com.eninse.businessbackend.dto.Address;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private User user;
	private Address address;
	private Cart cart;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.eninse.businessbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void testCRUDUser(){
//		
//		//Add user
//		user = new User();
//		user.setFirstName("Randrino");
//		user.setLastName("Nzeukang");
//		user.setEmail("nzeus@yahoo.fr");
//		user.setContactNumber("123456789");
//		user.setRole("USER");
//		assertEquals("Successfully added new user", true, userDAO.addUser(user));
//		
//		//Add addreess
//		address = new Address();
//		address.setPostalCode("20147");
//		address.setAddressLineOne("Via Paolo Segneri, 01");
//		address.setAddressLineTwo("Scala D");
//		address.setCity("Milano");
//		address.setCountry("Italia");
//		address.setBilling(true);
//		address.setUser(user);
//		assertEquals("Successfully added new address", true, userDAO.addAddress(address));
//		
//		//Add Cart
//		if(user.getRole().equals("USER")){
//			cart = new Cart();
//			cart.setUser(user);
//			assertEquals("Failed to add cart", true, userDAO.addCart(cart));
//			
//			address = new Address();
//			address.setPostalCode("20147");
//			address.setAddressLineOne("Via Paolo Segneri, 01");
//			address.setAddressLineTwo("Scala D");
//			address.setCity("Milano");
//			address.setCountry("Italia");
//			address.setShipping(true);
//			address.setUser(user);
//			assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));
//		}
//	}
	
//	@Test
//	public void testAddAddress(){
//		
//		//Add user
//		user = new User();
//		user = new User();
//		user.setFirstName("Randrino");
//		user.setLastName("Nzeukang");
//		user.setEmail("nzeus@yahoo.fr");
//		user.setContactNumber("123456789");
//		user.setPassword("Passaporto2003");
//		user.setRole("USER");
//		assertEquals("Successfully added new user", true, userDAO.addUser(user));
//		
//		//Add addreess Billing
//		address = new Address();
//		address.setPostalCode("20147");
//		address.setAddressLineOne("Via Paolo Segneri, 01");
//		address.setAddressLineTwo("Scala D");
//		address.setCity("Milano");
//		address.setCountry("Italia");
//		address.setBilling(true);
//		address.setUser(user);
//		assertEquals("Successfully added new address", true, userDAO.addAddress(address));
//		
//		//Add addreess Shipping
//		address = new Address();
//		address.setPostalCode("20133");
//		address.setAddressLineOne("Via Romagna Pascoli, 62");
//		address.setAddressLineTwo("Casa 62D");
//		address.setCity("Milano");
//		address.setCountry("Italia");
//		address.setShipping(true);
//		address.setUser(user);
//		assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));
//	}
	
//	@Test
//	public void testAddAddress(){
//		
//		//Add addreess Shipping
//		
//		user = userDAO.getByEmail("vtakou@yahoo.fr");
//		
//		address = new Address();
//		address.setPostalCode("20133");
//		address.setAddressLineOne("Via Romagna Pascoli, 62");
//		address.setAddressLineTwo("Casa 62D");
//		address.setCity("Milano");
//		address.setCountry("Italia");
//		address.setShipping(true);
//		address.setUser(user);
//		assertEquals("Failed to add shipping address", true, userDAO.addAddress(address));
//	}
	
	@Test
	public void testGetAddress(){
		
		user = userDAO.getByEmail("vtakou@yahoo.fr");
		
		assertEquals("List Shipping Address", 5, userDAO.listShippingAddress(user).size());
		
		assertEquals("List Billing Address", "Casa 62D", userDAO.getBillingAddress(user).getAddressLineTwo());
		
	}
}
