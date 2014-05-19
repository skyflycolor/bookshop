package com.service.impl;

import java.util.List;

import com.bean.OrderItem;
import com.dao.OrderItemDAO;
import com.dao.impl.OrderItemDAOImpl;
import com.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	OrderItemDAO od = new OrderItemDAOImpl();
	@Override
	public void add(OrderItem orderItem) {
		od.add(orderItem);
	}

	@Override
	public void delete(OrderItem orderItem) {
		od.delete(orderItem);
	}

	@Override
	public void update(OrderItem orderItem) {
		od.update(orderItem);
	}

	@Override
	public List<OrderItem> select() {
		return od.select();
	}

}
