package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDAO {
	public void add(User user);
	public void update(User user);
	public void delete(User user);
	public User load(Integer id);
	public List<User> select();
}
