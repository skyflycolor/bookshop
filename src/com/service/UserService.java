package com.service;

import java.util.List;

import com.bean.User;

public interface UserService {
	public void add(User user);
	public void delete(User user);
	public void update(User user);
	public List<User> select();
	public User login(String username, String password);
	public boolean usernameIsExist(String username);
}
