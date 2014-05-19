package com.service.impl;

import java.util.List;

import com.bean.Product;
import com.dao.ProductDAO;
import com.dao.impl.ProductDAOImpl;
import com.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	ProductDAO pd = new ProductDAOImpl();
	@Override
	public void add(Product product) {
		pd.add(product);
	}

	@Override
	public void delete(Product product) {
		pd.delete(product);
	}

	@Override
	public void update(Product product) {
		pd.update(product);
	}

	@Override
	public List<Product> select() {
		return pd.select();
	}

	@Override
	public List<Product> selectByCgId(int cgId) {
		return pd.selectByCgId(cgId);
	}

}
