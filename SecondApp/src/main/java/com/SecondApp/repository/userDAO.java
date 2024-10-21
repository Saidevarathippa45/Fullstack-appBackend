package com.SecondApp.repository;

import java.util.List;

import com.SecondApp.model.User;

public interface userDAO {

	public User registerUser(User user);
	public List<User> getAll();
	public String deleteUser(long userId);
}
