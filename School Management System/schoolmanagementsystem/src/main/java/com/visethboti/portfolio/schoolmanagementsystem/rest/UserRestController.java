package com.visethboti.portfolio.schoolmanagementsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visethboti.portfolio.schoolmanagementsystem.entity.User;
import com.visethboti.portfolio.schoolmanagementsystem.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	private UserService	userService;
	
	// inject user service (user constructor injection)
	@Autowired
	public UserRestController(@Qualifier("userServiceImpl") UserService userService) {
		this.userService = userService;
	}
	
	// expose "/users" and return list of users
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	// add mapping for GET /api/Users/{UserId}	Read a single User
		@GetMapping("/users/{userId}")
		public User getUser(@PathVariable int UserId) {
			User theUser = userService.findById(UserId);
			
			if(theUser == null) {
				throw new RuntimeException("User id not found - " + UserId);
			}
			
			return theUser;
		}
		
		// add mapping for POST /api/Users	add a new User
		@PostMapping("/users")
		public User addUser(@RequestBody User theUser) {
			// just in case they pas an id in JSON ... set id to 0
			// this is to force a save of a new item instead of update
			theUser.setUserID(0);
			
			userService.save(theUser);
			
			return theUser;
		}
		
		// add mapping for PUT	/api/Users Update an existing User
		@PutMapping("/users")
		public User updateUser(@RequestBody User theUser) {
			userService.save(theUser);
			
			return theUser;
		}
		
		// add mapping for DELETE	/api/employees/{UserId}	Delete an existing User
		@DeleteMapping("/users/{userId}")
		public String deleteUser(@PathVariable int UserId){
			User theUser = userService.findById(UserId);
			
			if(theUser == null) {
				throw new RuntimeException("User id not found - " + UserId);
			}
			
			userService.deleteById(UserId);
			
			return "Deleted User id - " + UserId;
			
		}
}
