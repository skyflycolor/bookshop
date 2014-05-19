package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConn {
    private static final String url = "jdbc:mysql://localhost:3306/bookshop?useUnicode=true&characterEncoding=utf8";
    private static final String user="root";
    private static final String password="123456";
    private static final String driverName="com.mysql.jdbc.Driver";
    
	public static Connection getConn() throws SQLException{
		Connection conn=null;
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
