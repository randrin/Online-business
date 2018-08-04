package com.eninse.businessbackend.dao;

import java.util.List;

import com.eninse.businessbackend.dto.Category;

public interface CategoryDAO {

	public boolean add(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public List<Category> listCategory();
	Category get(int id);
}
