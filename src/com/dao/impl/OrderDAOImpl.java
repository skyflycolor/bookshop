package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.bean.Order;
import com.dao.OrderDAO;
import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.db.DBConn;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void add(Order order) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="insert into order(user_id,orderdate,status) values (?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,order.getUser().getId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar c=Calendar.getInstance();
			pst.setString(2,sdf.format(c.getTime()));
			pst.setInt(3, order.getStatus());
			
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
	public void update(Order order) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="update order set user_id=?,status=? where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,order.getUser().getId());
			pst.setInt(2, order.getStatus());
			pst.setInt(3, order.getId());
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
	public void delete(Order order) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql = "delete from order where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, order.getId());
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
	public Order load(Integer id) {
		Order order=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from order where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				order=new Order();
				order.setId(rs.getInt("id"));
				UserDAO ud = new UserDAOImpl();
				order.setUser(ud.load(rs.getInt("user_id")));
				order.setOrderdate(rs.getString("orderdate"));
				order.setStatus(rs.getInt("status"));
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
		
		return order;
	}

	@Override
	public List<Order> select() {
		List<Order> orders=new ArrayList<Order>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from order";
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Order order=new Order();
				order.setId(rs.getInt("id"));
				UserDAO ud = new UserDAOImpl();
				order.setUser(ud.load(rs.getInt("user_id")));
				order.setOrderdate(rs.getString("orderdate"));
				order.setStatus(rs.getInt("status"));
				
				orders.add(order);
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
		
		return orders;
	}

}
