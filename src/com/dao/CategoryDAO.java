package com.dao;

import java.util.List;

import com.bean.Category;

public interface CategoryDAO {
	public void add(Category category);
	public void update(Category category);
	public void delete(Category category);
	public Category load(Integer id);
	public List<Category> select();
}
