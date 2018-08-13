package com.eninse.businessbackend.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 4131808112189653426L;

	/*
	 * Private Fields Users Products
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	@NotBlank(message="Please enter the product name")
	private String name;
	
	@NotBlank(message="Please enter the product brand")
	private String brand;
	
	@JsonIgnore
	@NotBlank(message="Please enter the product description")
	private String description;
	
	@Column(name="unit_price")
	@Min(value=1, message="The price cannot less than 1")
	private double unitPrice;
	
	private int quantity;
	
	@Column(name="category_id")
	@JsonIgnore
	private int categoryId;
	
	@Column(name="supplier_id")
	@JsonIgnore
	private int supplierId;
	
	@Column(name="is_active")
	@JsonIgnore
	private boolean active = true;
	
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile file;
	
	public Product() {
		this.code = "PRD" +UUID.randomUUID().toString().substring(20).toUpperCase();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name
				+ ", brand=" + brand + ", description=" + description
				+ ", unitPrice=" + unitPrice + ", quantity=" + quantity
				+ ", categoryId=" + categoryId + ", supplyId=" + supplierId
				+ ", active=" + active + ", purchases=" + purchases
				+ ", views=" + views + "]";
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
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
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}
	/**
	 * @param supplyId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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
	/**
	 * @return the purchases
	 */
	public int getPurchases() {
		return purchases;
	}
	/**
	 * @param purchases the purchases to set
	 */
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	/**
	 * @return the views
	 */
	public int getViews() {
		return views;
	}
	/**
	 * @param views the views to set
	 */
	public void setViews(int views) {
		this.views = views;
	}

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
