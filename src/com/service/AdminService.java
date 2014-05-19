package com.service;

import java.util.List;

import com.bean.Admin;

public interface AdminService {
	public void add(Admin admin);
	public void delete(Admin admin);
	public void update(Admin admin);
	public List<Admin> select();
	public Admin login(String adminname, String password);
}
