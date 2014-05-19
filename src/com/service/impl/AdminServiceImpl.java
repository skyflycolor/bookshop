package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.Admin;
import com.dao.AdminDAO;
import com.dao.impl.AdminDAOImpl;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDAO ad = new AdminDAOImpl();
	@Override
	public void add(Admin admin) {
		ad.add(admin);
	}

	@Override
	public void delete(Admin admin) {
		ad.delete(admin);
	}

	@Override
	public void update(Admin admin) {
		ad.update(admin);
	}

	@Override
	public List<Admin> select() {
		return ad.select();
	}

	@Override
	public Admin login(String adminname, String password) {
		List<Admin> admins = new ArrayList<Admin>();
		admins = ad.select();
		for(int i = 0; i < admins.size(); i++){
			if(admins.get(i).getAdminName().equals(adminname) && admins.get(i).getPassword().equals(password)){
				return admins.get(i);
			}
		}
		return null;
	}

}
