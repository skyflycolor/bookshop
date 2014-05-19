package com.dao;

import java.util.List;

import com.bean.Admin;

public interface AdminDAO {
	public void add(Admin admin);
	public void update(Admin admin);
	public void delete(Admin admin);
	public Admin load(Integer id);
	public List<Admin> select();
}
