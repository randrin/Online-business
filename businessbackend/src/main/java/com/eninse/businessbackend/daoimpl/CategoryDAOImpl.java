package com.eninse.businessbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dto.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<Category>();

	static {
		// First Item
		Category category = new Category();
		category.setId(1);
		category.setDescription("Sac de Mode");
		category.setName("Mode");
		category.setImageURl("CAT_1.png");
		categories.add(category);
		
		// Second Item
		category = new Category();
		category.setId(2);
		category.setDescription("Make up de Mode");
		category.setName("Beauté");
		category.setImageURl("CAT_2.png");
		categories.add(category);
		
		// Second Item
		category = new Category();
		category.setId(3);
		category.setDescription("Vetements Femmes de Mode");
		category.setName("Evenemenet");
		category.setImageURl("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> listCategory() {
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for (Category cat : categories){
			if (cat.getId() == id)
				return cat;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {

		try{
			//Add categories to H2 Database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
