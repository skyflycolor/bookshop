package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.OrderItem;
import com.dao.ProductDAO;
import com.dao.OrderDAO;
import com.dao.OrderItemDAO;
import com.db.DBConn;

public class OrderItemDAOImpl implements OrderItemDAO {

	@Override
	public void add(OrderItem orderItem) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="insert into orderItem(product_id,productcount,selasOrder_id) values (?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,orderItem.getProduct().getId());
			pst.setInt(2,orderItem. getProductcount());
			pst.setInt(3,orderItem.getSelasOrder().getId());
			pst.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				
			}
		}

	}

	@Override
	public void update(OrderItem orderItem) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="update orderItem set product_id=?,productcount=?,selasOrder_id=? where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,orderItem.getProduct().getId());
			pst.setInt(2,orderItem. getProductcount());
			pst.setInt(3,orderItem.getSelasOrder().getId());
			pst.setInt(4, orderItem.getId());
			pst.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				
			}
		}

	}

	@Override
	public void delete(OrderItem orderItem) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql = "delete from orderItem where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, orderItem.getId());
			pst.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				
			}
		}
	}

	@Override
	public OrderItem load(Integer id) {
		OrderItem orderItem=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from orderItem where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				orderItem=new OrderItem();
				orderItem.setId(rs.getInt("id"));
				ProductDAO pd = new ProductDAOImpl();
				orderItem.setProduct(pd.load(rs.getInt("product_id")));
				orderItem.setProductcount(rs.getInt("productcount"));
				OrderDAO sd = new OrderDAOImpl();
				orderItem.setSelasOrder(sd.load(rs.getInt("orderItem_id")));
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				
			}
		}
		
		return orderItem;
	}

	@Override
	public List<OrderItem> select() {
		List<OrderItem> orderItems=new ArrayList<OrderItem>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from orderItem";
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				OrderItem orderItem=new OrderItem();
				orderItem.setId(rs.getInt("id"));
				ProductDAO pd = new ProductDAOImpl();
				orderItem.setProduct(pd.load(rs.getInt("product_id")));
				orderItem.setProductcount(rs.getInt("productcount"));
				OrderDAO sd = new OrderDAOImpl();
				orderItem.setSelasOrder(sd.load(rs.getInt("orderItem_id")));
				orderItems.add(orderItem);
			}
		}catch(Exception e){
			
		}finally{
			try{
				if(pst!=null){
					pst.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(Exception e){
				
			}
		}
		
		return orderItems;
	}

}
