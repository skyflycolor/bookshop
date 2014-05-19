package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.dao.ProductDAO;
import com.dao.CategoryDAO;
import com.db.DBConn;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void add(Product product) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="insert into Product(productname,logo,discription,price,category_id) values (?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,product.getProductname());
			pst.setString(2, product.getLogo());
			pst.setString(3,product.getDiscription());
			pst.setString(4, product.getPrice());
			pst.setInt(5, product.getCategory().getId());
			
			pst.executeUpdate();
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

	}

	@Override
	public void update(Product product) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="update product set productname=?,logo=?,discription=?,price=?,category_id=? where id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,product.getProductname());
			pst.setString(2, product.getLogo());
			pst.setString(3, product.getDiscription());
			pst.setString(4, product.getPrice());
			pst.setInt(5, product.getCategory().getId());
			pst.setInt(6, product.getId());
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
	public void delete(Product product) {
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql = "delete from product where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, product.getId());
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
	public Product load(Integer id) {
		Product product=null;
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from product where id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				product=new Product();
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setLogo(rs.getString("logo"));
				product.setDiscription(rs.getString("discription"));
				product.setPrice(rs.getString("price"));
				CategoryDAO cd = new CategoryDAOImpl();
				product.setCategory(cd.load(rs.getInt("category_id")));
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
		
		return product;
	}

	@Override
	public List<Product> select() {
		List<Product> products=new ArrayList<Product>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from product";
			pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setLogo(rs.getString("logo"));
				product.setDiscription(rs.getString("discription"));
				product.setPrice(rs.getString("price"));
				CategoryDAO cd = new CategoryDAOImpl();
				product.setCategory(cd.load(rs.getInt("category_id")));
				products.add(product);
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
		
		return products;
	}

	@Override
	public List<Product> selectByCgId(int cgId) {
		List<Product> products=new ArrayList<Product>();
		
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			conn=DBConn.getConn();
			String sql="select * from product where category_id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, cgId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setProductname(rs.getString("productname"));
				product.setLogo(rs.getString("logo"));
				product.setDiscription(rs.getString("discription"));
				product.setPrice(rs.getString("price"));
				CategoryDAO cd = new CategoryDAOImpl();
				product.setCategory(cd.load(rs.getInt("category_id")));
				products.add(product);
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
		
		return products;
	}

}
