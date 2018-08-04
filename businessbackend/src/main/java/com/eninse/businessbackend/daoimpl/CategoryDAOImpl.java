package com.eninse.businessbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dto.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();

	static {
		// First Item
		Category category = new Category();
		category.setId(1);
		category.setDescription("Sac de Mode");
		category.setName("Gucci");
		category.setImageURl("CAT_1.png");
		categories.add(category);
		
		// Second Item
		category = new Category();
		category.setId(2);
		category.setDescription("Make up de Mode");
		category.setName("Mascara");
		category.setImageURl("CAT_2.png");
		categories.add(category);
		
		// Second Item
		category = new Category();
		category.setId(3);
		category.setDescription("Vetements Femmes de Mode");
		category.setName("Robes de soiréee");
		category.setImageURl("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> listCategory() {
		// TODO Auto-gene+rated method stub
		return categories;
	}

}
