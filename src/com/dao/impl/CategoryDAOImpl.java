package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Category;
import com.dao.CategoryDAO;
import com.db.DBConn;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public void add(Category category) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="insert into category(name,logo) values (?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,category.getName());
			pst.setString(2,category.getLogo());
			
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
	public void update(Category category) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="update category set name=?,logo=? where id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,category.getName());
			pst.setString(2,category.getLogo());
			pst.setInt(3, category.getId());
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
	public void delete(Category category) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql = "delete from category where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, category.getId());
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
	public Category load(Integer id) {
		Category category=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from category where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				category=new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setLogo(rs.getString("logo"));
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
		
		return category;
	}

	@Override
	public List<Category> select() {
		List<Category> categorys=new ArrayList<Category>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from category";
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Category category=new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				category.setLogo(rs.getString("logo"));
				categorys.add(category);
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
		
		return categorys;
	}

}
