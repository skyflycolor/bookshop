package com.service.impl;

import java.util.List;

import com.bean.Category;
import com.dao.CategoryDAO;
import com.dao.impl.CategoryDAOImpl;
import com.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDAO cd = new CategoryDAOImpl();
	@Override
	public void add(Category category) {
		cd.add(category);
	}

	@Override
	public void delete(Category category) {
		cd.delete(category);
	}

	@Override
	public void update(Category category) {
		cd.update(category);
	}

	@Override
	public List<Category> select() {
		return cd.select();
	}

	@Override
	public Category load(Integer id) {
		return cd.load(id);
	}

}
