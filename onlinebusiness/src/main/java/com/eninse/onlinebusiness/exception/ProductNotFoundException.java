package com.eninse.onlinebusiness.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{

	private static final long serialVersionUID = -4093348135142369969L;
	String message;
	
	
	public void setMessage(String message) {
		this.message = message;
	}

	public ProductNotFoundException() {
		this.message = "Prduct is not available";
	}
	
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " +message;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
}
