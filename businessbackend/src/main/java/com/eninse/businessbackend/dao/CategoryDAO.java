package com.eninse.businessbackend.dao;

import java.util.List;

import com.eninse.businessbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> listCategory();
	Category get(int id);
}
