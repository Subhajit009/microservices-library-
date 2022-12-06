package com.epam.user.dto;

public class UserDto {
	
	String username;

	String email;
	String name;
	
	
	
	public UserDto() {
	}
	public UserDto(String username, String email, String name) {
		this.username = username;
		this.email = email;
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", email=" + email + ", name=" + name + "]";
	}
	

}
