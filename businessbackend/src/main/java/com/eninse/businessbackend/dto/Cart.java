package com.eninse.businessbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart implements Serializable{

	private static final long serialVersionUID = -7020460231912969338L;

	/*
	 * Private Fields Category Products
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	private double total;
	
	@Column(name="cart_lines")
	private int carttLines;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", total=" + total
				+ ", carttLines=" + carttLines + "]";
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
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the carttLines
	 */
	public int getCarttLines() {
		return carttLines;
	}

	/**
	 * @param carttLines the carttLines to set
	 */
	public void setCarttLines(int carttLines) {
		this.carttLines = carttLines;
	}
	
}
