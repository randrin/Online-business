package com.eninse.businessbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dao.ProductDAO;
import com.eninse.businessbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Get Single Product in H2 Database
	 */
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory
					.getCurrentSession()
					.get(Product.class, Integer.valueOf(productId));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Get All List Product in H2 Database
	 */
	@Override
	public List<Product> listProduct() {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product", Product.class)
				.getResultList();
	}

	/*
	 * Add/Create  Product in H2 Database
	 */
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory
					.getCurrentSession()
					.persist(product);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * Delete Product in H2 Database
	 */
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory
					.getCurrentSession()
					.update(product);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * Update Product in H2 Database
	 */
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory
					.getCurrentSession()
					.update(product);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * Get all Product active in H2 Database
	 */
	@Override
	public List<Product> listActiveProducts() {
		String activeProduct = "FROM Product WHERE active = :active";
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(activeProduct, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	/*
	 * Get all Product active by Category in H2 Database
	 */
	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String activeProduct = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(activeProduct, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	/*
	 * Get all Product latest active in H2 Database
	 */
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String activeProduct = "FROM Product WHERE active = :active ORDER BY id";
		
		return sessionFactory
				.getCurrentSession()
				.createQuery(activeProduct, Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
