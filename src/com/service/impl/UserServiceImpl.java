package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO ud = new UserDAOImpl();
	@Override
	public void add(User user) {
		ud.add(user);
	}

	@Override
	public void delete(User user) {
		ud.delete(user);
	}

	@Override
	public void update(User user) {
		ud.update(user);
	}

	@Override
	public List<User> select() {
		return ud.select();
	}

	@Override
	public User login(String username, String password) {
		List<User> users = new ArrayList<User>();
		users = ud.select();
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)){
				return users.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean usernameIsExist(String username) {
		List<User> users = new ArrayList<User>();
		users = ud.select();
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}

}
