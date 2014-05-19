package com.service;

import java.util.List;

import com.bean.Category;

public interface CategoryService {
	public void add(Category category);
	public void delete(Category category);
	public void update(Category category);
	public List<Category> select();
	public Category load(Integer id);
}
