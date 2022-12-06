package com.epam.user.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.user.database.UserEntity;
import com.epam.user.dto.UserDto;
import com.epam.user.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("users")
	public ResponseEntity<List<UserEntity>> getUsers()
	{
		return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
	}
	
	@GetMapping("users/{username}")
	public ResponseEntity<UserEntity> getUsersByUsername(@PathVariable("username") String username)
	{
		return new ResponseEntity<>(userService.getUserByUsername(username),HttpStatus.OK);
	}
	
	@PostMapping("users")
	public ResponseEntity<String> insertUser(@RequestBody UserDto userDto)
	{
		userService.insertUser(userDto);
		return new ResponseEntity<>("User added!!!",HttpStatus.CREATED);
	}
	
	@DeleteMapping("users/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username)
	{
		userService.remove(username);
		 return ResponseEntity.noContent().build();
	}
	
	@PutMapping("users/{username}")
	public ResponseEntity<String> updateUser(@PathVariable("username") String username,@RequestBody UserDto userDto)
	{
		userService.updateUser(username,userDto);
		return new ResponseEntity<>("User updated!!!",HttpStatus.OK);
		
	}

}
