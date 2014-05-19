package com.bean;

public class OrderItem {
	private int id;
	private Product product;
	private int productcount;
	private Order selasOrder;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductcount() {
		return productcount;
	}
	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}
	public Order getSelasOrder() {
		return selasOrder;
	}
	public void setSelasOrder(Order selasOrder) {
		this.selasOrder = selasOrder;
	}
}
