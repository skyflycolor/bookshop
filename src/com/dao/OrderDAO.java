package com.dao;

import java.util.List;

import com.bean.Order;

public interface OrderDAO {
	public void add(Order order);
	public void update(Order order);
	public void delete(Order order);
	public Order load(Integer id);
	public List<Order> select();
}
