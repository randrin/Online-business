package com.eninse.businessbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dao.ProductDAO;
import com.eninse.businessbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private Product product;
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.eninse.businessbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		
		//Test Add Product
		product = new Product();
		product.setName("Iphone 8");
		product.setDescription("The new Iphone 8 available in the OnlineShopping Store");
		product.setBrand("Smartphone");
		product.setUnitPrice(5986745);
		product.setQuantity(3);
		product.setActive(true);
		product.setCategoryId(2);
		product.setPurchases(1);
		product.setViews(8);
		product.setSupplierId(2);
		assertEquals("Product add Succeffully", true, productDAO.add(product));
		
		//Test Update Product
		product = productDAO.get(1);
		product.setName("Samsung S7 Plus");
		assertEquals("Product updated succeffullìy", true, productDAO.update(product));
		
		//Test Delete Product
		product = productDAO.get(1);
		assertEquals("Delete Succeffully Category", true, productDAO.delete(product));
		
		//Test list Product
		assertEquals("List of Product", 4, productDAO.listProduct().size());
	}
	
	@Test
	public void testActiveProducts() {
		assertEquals("List of Active Products", 3, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testActiveProductsByCategory(){
		assertEquals("List of Active Products By Category", 1, productDAO.listActiveProductsByCategory(2).size());
	}
	
	@Test
	public void testGetLatestActiveProducts(){
		assertEquals("List of Active Products By Category", 1, productDAO.getLatestActiveProducts(1).size());
	}
}
