package com.eninse.onlinebusiness.model;

import java.io.Serializable;

import com.eninse.businessbackend.dto.Cart;

public class ProfileUserModel implements Serializable {

	private static final long serialVersionUID = -427670238915720225L;
	
	//User
	private int id;
	private String fullName;
	private String gender;
	private String email;
	private String role;
	private String contactNumber;
	private Cart cart;
	
	//Address
	private String addressLineOne;
	private String addressLineTwo;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	
	//Boolean to show or hide the menu SIGN UP/LOGIN
	private boolean isLogged = false;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfileUserModel [id=" + id + ", fullName=" + fullName
				+ ", gender=" + gender + ", email=" + email + ", role=" + role
				+ ", contactNumber=" + contactNumber + ", cart=" + cart
				+ ", addressLineOne=" + addressLineOne + ", addressLineTwo="
				+ addressLineTwo + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", postalCode=" + postalCode
				+ ", isLogged=" + isLogged + "]";
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the cart
	 */
	public Cart getCart() {
		return cart;
	}
	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	/**
	 * @return the isLogged
	 */
	public boolean isLogged() {
		return isLogged;
	}

	/**
	 * @param isLogged the isLogged to set
	 */
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * @param addressLineOne the addressLineOne to set
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	/**
	 * @return the addressLineTwo
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	/**
	 * @param addressLineTwo the addressLineTwo to set
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
}
