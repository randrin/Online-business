package com.eninse.businessbackend.dao;

import java.util.List;

import com.eninse.businessbackend.dto.Address;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean addAddress(Address address);
	public boolean addCart(Cart cart);
	public User getByEmail (String email);
	public Address getBillingAddress(User user);
	public List<Address> listShippingAddress(User user);
	
	// updating the cart
	public boolean updateCart(Cart cart);
	
}
