package com.app.service.impl.copy;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.exception.ResourceNotFoundException;
import com.app.repo.UserRepo;
import com.app.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;
	@Override
	public User createUser(User user) {
		User savedUser=this.userRepo.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		return user;
	}

	
}
