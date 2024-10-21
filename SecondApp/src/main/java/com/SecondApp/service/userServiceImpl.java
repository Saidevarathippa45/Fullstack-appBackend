package com.SecondApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SecondApp.model.User;
import com.SecondApp.repository.userDAO;

import jakarta.transaction.Transactional;

@Service
public class userServiceImpl implements userService{

	@Autowired
	userDAO userdao;
	@Override
	@Transactional
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("im in Service");
		return userdao.registerUser(user);
	}
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userdao.getAll();
	}
	@Transactional
	public String deleteUser(long userId) {
		userdao.deleteUser(userId);
				return "user deleted successfully";
	}

}
