package com.service;

import java.util.List;

import com.bean.Product;

public interface ProductService {
	public void add(Product product);
	public void delete(Product product);
	public void update(Product product);
	public List<Product> select();
	public List<Product> selectByCgId(int cgId);
	
}
