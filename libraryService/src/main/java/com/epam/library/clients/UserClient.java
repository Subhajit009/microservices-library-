package com.epam.library.clients;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.library.dto.UserBean;



@FeignClient(name="usersService")
@LoadBalancerClient(name = "usersService")
public interface UserClient
{

	@GetMapping("users")
	public ResponseEntity<List<UserBean>> getUsers();
	
	@GetMapping("users/{username}")
	public ResponseEntity<UserBean> getUsersByUsername(@PathVariable("username") String username);
	
	@PostMapping("users")
	public ResponseEntity<String> insertUser(@RequestBody UserBean userDto);
	
	@DeleteMapping("users/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username);
	
	@PutMapping("users/{username}")
	public ResponseEntity<String> updateUser(@PathVariable("username") String username,@RequestBody UserBean userDto);

}
