package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Admin;
import com.dao.AdminDAO;
import com.db.DBConn;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public void add(Admin admin) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="insert into admin(adminname,password) values (?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,admin.getAdminName());
			pst.setString(2, admin.getPassword());
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
	public void update(Admin admin) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="update admin set adminname=?,password=? where id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,admin.getAdminName());
			pst.setString(2, admin.getPassword());
			pst.setInt(3, admin.getId());
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
	public void delete(Admin admin) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql = "delete from admin where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, admin.getId());
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
	public Admin load(Integer id) {
		Admin admin=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from admin where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAdminName(rs.getString("adminname"));
				admin.setPassword(rs.getString("password"));
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
		
		return admin;
	}

	@Override
	public List<Admin> select() {
		List<Admin> admins=new ArrayList<Admin>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from admin";
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Admin admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAdminName(rs.getString("adminname"));
				admin.setPassword(rs.getString("password"));
				admins.add(admin);
			}
		}catch(Exception e){
			e.printStackTrace();
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
		
		return admins;
	}
}
