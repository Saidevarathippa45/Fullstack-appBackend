package com.SecondApp.service;

import java.util.List;

import com.SecondApp.model.User;

public interface userService {

	public User registerUser(User user);
	public List<User> getAll();
	public String deleteUser(long userId);
}
