package com.eninse.businessbackend.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dto.Product;

public interface ProductDAO {

	//CRUD Operations Products
	public Product get (int productId);
	public List<Product> listProduct();
	public boolean add(Product product);
	public boolean delete(Product product);
	public boolean update(Product product);
	
	//Bussiness Methods
	public List<Product> listActiveProducts();
	public List<Product> listActiveProductsByCategory(int categoryId);
	public List<Product> getLatestActiveProducts(int count);
	
}
