package com.service.impl;

import java.util.List;

import com.bean.Order;
import com.dao.OrderDAO;
import com.dao.impl.OrderDAOImpl;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDAO od = new OrderDAOImpl();
	@Override
	public void add(Order order) {
		od.add(order);
	}

	@Override
	public void delete(Order order) {
		od.delete(order);
	}

	@Override
	public void update(Order order) {
		od.update(order);
	}

	@Override
	public List<Order> select() {
		return od.select();
	}

}
