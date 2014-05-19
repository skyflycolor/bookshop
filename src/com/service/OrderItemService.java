package com.service;

import java.util.List;

import com.bean.OrderItem;

public interface OrderItemService {
	public void add(OrderItem orderItem);
	public void delete(OrderItem orderItem);
	public void update(OrderItem orderItem);
	public List<OrderItem> select();
}
