package com.dao;

import java.util.List;

import com.bean.OrderItem;

public interface OrderItemDAO {
	public void add(OrderItem orderItem);
	public void update(OrderItem orderItem);
	public void delete(OrderItem orderItem);
	public OrderItem load(Integer id);
	public List<OrderItem> select();
}
