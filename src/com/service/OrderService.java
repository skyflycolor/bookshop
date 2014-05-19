package com.service;

import java.util.List;

import com.bean.Order;

public interface OrderService {
	public void add(Order order);
	public void delete(Order order);
	public void update(Order order);
	public List<Order> select();
}
