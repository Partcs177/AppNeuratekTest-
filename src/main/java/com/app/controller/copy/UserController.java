package com.app.controller.copy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User createUser = userService.createUser(user);
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.getAllUsers();
		return ResponseEntity.ok(users);
		
	}//Get user
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable Integer userId){
		User user=userService.getUserById(userId);
		return ResponseEntity.ok(user);
		
	}
	@GetMapping("/msg")
	public String userMessage() {
		return "Hi, msg api called sucessfilly";
		
	}
}
