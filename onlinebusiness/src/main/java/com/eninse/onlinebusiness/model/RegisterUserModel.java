package com.eninse.onlinebusiness.model;

import java.io.Serializable;

import com.eninse.businessbackend.dto.Address;
import com.eninse.businessbackend.dto.User;

public class RegisterUserModel implements Serializable{
	
	private static final long serialVersionUID = 1815272343134657539L;
	
	private User user;
	private Address billing;
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the billing
	 */
	public Address getBilling() {
		return billing;
	}
	/**
	 * @param billing the billing to set
	 */
	public void setBilling(Address billing) {
		this.billing = billing;
	}
	
}
