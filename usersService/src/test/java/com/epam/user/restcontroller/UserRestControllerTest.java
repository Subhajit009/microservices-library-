package com.epam.user.restcontroller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.user.dto.UserDto;
import com.epam.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

	@MockBean
	UserService userService;
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void testgetUsers() throws Exception {
		mockMvc.perform(get("/users")).andExpect(status().is(200));
	}
	
	@Test
	void testgetUserById() throws Exception
	{
		mockMvc.perform(get("/users/{username}",1)).andExpect(status().is(200));
	}
	
	@Test
	void testInsertUser() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		UserDto userDto=new UserDto();
		userDto.setEmail("okay");
		userDto.setName("yes");
		userDto.setUsername("Sub");
		mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userDto))).andExpect(status().is(201));

	}
	
	@Test
	void testDeleteUser() throws Exception
	{
		mockMvc.perform(delete("/users/{username}",1)).andExpect(status().is(204));

	}
	
	
	@Test
	void testUpdateUser() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		UserDto userDto=new UserDto();
		userDto.setEmail("okay");
		userDto.setName("yes");
		userDto.setUsername("Sub");
		mockMvc.perform(put("/users/{username}",1).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userDto))).andExpect(status().is(200));

	}
	

}
