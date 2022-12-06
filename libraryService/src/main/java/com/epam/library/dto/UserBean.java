package com.epam.library.dto;

public class UserBean {

	int id;
	String username;
	String email;
	String name;
	
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", email=" + email + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
