package com.eninse.businessbackend.dto;

import java.io.Serializable;

public class Category implements Serializable{
	
	private static final long serialVersionUID = 2203804623868410125L;
	
	/*
	 * Private Fields Category Products
	 */
	private int id;
	private String name;
	private String description;
	private String imageURl;
	private boolean active = true;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the imageURl
	 */
	public String getImageURl() {
		return imageURl;
	}
	/**
	 * @param imageURl the imageURl to set
	 */
	public void setImageURl(String imageURl) {
		this.imageURl = imageURl;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
