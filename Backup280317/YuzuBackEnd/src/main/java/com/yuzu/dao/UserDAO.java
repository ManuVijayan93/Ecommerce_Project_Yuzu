package com.yuzu.dao;

import java.util.List;

import com.yuzu.domain.User;

public interface UserDAO {

	public List<User> list();

	public User getUser(int id);

	public User getUser(String name);

	public boolean save(User user);

	public boolean update(User user);

	public boolean validate(String name, String password);

}
