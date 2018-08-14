package com.eninse.businessbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	public static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
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
			log.error("Error trying to add category with id= " +category.getId()+ " , " +e.getMessage()+ " - " +e.getCause());
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
			log.error("Error trying to update category with id= " +category.getId()+ " , " +e.getMessage()+ " - " +e.getCause());
			return false;
		}
	}

	/*
	 * Delete Single Category in H2 Database
	 */
	@Override
	public boolean delete(Category category) {
		try{
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			log.error("Error trying to delete category with id= " +category.getId()+ " , " +e.getMessage()+ " - " +e.getCause());
			return false;
		}
	}
}
