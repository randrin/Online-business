package com.eninse.businessbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eninse.businessbackend.dao.CategoryDAO;
import com.eninse.businessbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private Category category;
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.eninse.businessbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddcategory(){
//		category = new Category();
//		
//		category.setDescription("Sac de Mode");
//		category.setName("Mode");
//		category.setImageURl("CAT_1.png");
//		
//		assertEquals("Add succeffully Category", true, categoryDAO.add(category));
//	}
	
//	@Test
//	public void testGetCategory(){
//		category = categoryDAO.get(1);
//		assertEquals("Get succeffully Category", "Mode", category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory(){
//		category = categoryDAO.get(1);
//		category.setName("Mode Vestimentaire");
//		assertEquals("Update Succeffully Category", true, categoryDAO.update(category));
//	}
//	
//	@Test
//	public void testDeleteCategory(){
//		category = categoryDAO.get(1);
//		assertEquals("Update Succeffully Category", true, categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testistCategory(){
//		assertEquals("List of Category", 1, categoryDAO.listCategory().size());
//	}
	
	@Test
	public void testCRUDCategory() {
		
		//Test Add Category
		category = new Category();
		category.setDescription("Sacs de Mode");
		category.setName("Mode");
		category.setImageURl("CAT_1.png");
		assertEquals("Add Category 1 succeffully Category", true, categoryDAO.add(category));
		
		category = new Category();
		category.setDescription("Appareils Electroniques");
		category.setName("Electronique");
		category.setImageURl("CAT_2.png");
		assertEquals("Add Category 2 succeffully Category", true, categoryDAO.add(category));
		
		//Test Update Category
		category = categoryDAO.get(2);
		category.setName("Appareils de Marque");
		assertEquals("Update Succeffully Category", true, categoryDAO.update(category));
		
		//Test Delete Category
		category = categoryDAO.get(1);
		assertEquals("delete Succeffully Category", true, categoryDAO.delete(category));
		
		//Test list Category
		assertEquals("List of Category", 1, categoryDAO.listCategory().size());
	}
}
