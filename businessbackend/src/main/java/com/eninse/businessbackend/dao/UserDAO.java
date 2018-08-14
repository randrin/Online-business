package com.eninse.businessbackend.dao;

import com.eninse.businessbackend.dto.Address;
import com.eninse.businessbackend.dto.Cart;
import com.eninse.businessbackend.dto.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean addAddress(Address address);
	public boolean addCart(Cart cart);
}
