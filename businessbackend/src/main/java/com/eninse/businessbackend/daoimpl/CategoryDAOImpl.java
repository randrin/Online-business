package com.eninse.businessbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Get List Category in H2 Database
	 */
	@Override
	public List<Category> listCategory() {
		
		String listCategory = "FROM Category WHERE active = :active";
		Query query  = sessionFactory.getCurrentSession().createQuery(listCategory);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/*
	 * Get Single Category with specific id in H2 Database
	 */
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	/*
	 * Add Single Category in H2 Database
	 */
	@Override
	public boolean add(Category category) {
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Update Single Category in H2 Database
	 */
	@Override
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Delete Single Category in H2 Database
	 */
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
