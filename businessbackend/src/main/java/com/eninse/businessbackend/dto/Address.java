package com.eninse.businessbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable{

	private static final long serialVersionUID = -482207266983251236L;

	/*
	 * Private Fields Users Products
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private User user;
	
	@Column(name="address_line_one")
	@NotBlank(message="Please enter the address name")
	private String addressLineOne;
	
	@Column(name="address_line_two")
	@NotBlank(message="Please enter the address name")
	private String addressLineTwo;
	
	@NotBlank(message="Please enter the city")
	private String city;
	
	@NotBlank(message="Please enter the state")
	private String state;
	
	@NotBlank(message="Please enter the country")
	private String country;
	
	@Column(name="postal_code")
	@NotBlank(message="Please enter the postal code")
	private String postalCode;
	
	private boolean shipping;
	private boolean billing;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [id=" + id + ", user=" + user + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + ", shipping="
				+ shipping + ", billing=" + billing + "]";
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
	 * @return the userId
	 */
	
	/**
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}
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
	/**
	 * @return the billing
	 */
	public boolean isBilling() {
		return billing;
	}
	/**
	 * @param billing the billing to set
	 */
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	/**
	 * @return the shipping
	 */
	public boolean isShipping() {
		return shipping;
	}
	/**
	 * @param shipping the shipping to set
	 */
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	
}
