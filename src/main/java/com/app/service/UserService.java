package com.app.service;

import java.util.List;



import com.app.entity.User;


public interface UserService {
	public User createUser(User user);

	public List<User> getAllUsers();

	public User getUserById(Integer userId);
}
