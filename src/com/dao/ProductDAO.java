package com.dao;

import java.util.List;

import com.bean.Product;

public interface ProductDAO {
	public void add(Product product);
	public void update(Product product);
	public void delete(Product product);
	public Product load(Integer id);
	public List<Product> select();
	public List<Product> selectByCgId(int cgId);
}
