package com.epam.library.restcontrollers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.library.clients.BookClient;
import com.epam.library.clients.UserClient;
import com.epam.library.dto.BookBean;
import com.epam.library.dto.UserBean;
import com.epam.library.service.LibraryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LibraryBookController.class)
class LibraryBookControllerTest {

	@MockBean
	BookClient bookClient;
	
	@MockBean
	UserClient userClient;
	
	@MockBean
	LibraryService libraryService;
	
	@Autowired
	MockMvc mockMvc;

	@Test
	void testGetAllBooksFromLibrary() throws Exception {
		mockMvc.perform(get("/library/books")).andExpect(status().is(200));
	}
	

	@Test
	void testGetBookById() throws Exception
	{
		mockMvc.perform(get("/library/books/{bookId}",1)).andExpect(status().is(200));
	}
	
	@Test
	void testInsertBook() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		BookBean bookBean=new BookBean();
		bookBean.setAuthor("I am");
		bookBean.setName("this is");
		bookBean.setPublisher("yess d");
		mockMvc.perform(post("/library/books").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookBean))).andExpect(status().is(200));

	}
	
	@Test
	void testDeleteBook() throws Exception
	{
		mockMvc.perform(delete("/library/books/{bookId}",1)).andExpect(status().is(200));

	}
	
	@Test
	void testUpdateBook() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		BookBean bookBean=new BookBean();
		bookBean.setAuthor("I am");
		bookBean.setName("this is");
		bookBean.setPublisher("yess d");
		mockMvc.perform(put("/library/books/{bookId}",1).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookBean))).andExpect(status().is(200));

	}
	
	@Test
	void testGetAllUsers() throws Exception {
		mockMvc.perform(get("/library/users")).andExpect(status().is(200));
	}
	
	@Test
	void testInsertUser() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		UserBean userBean=new UserBean();
		userBean.setEmail("okay");
		userBean.setName("yes");
		userBean.setUsername("Sub");
		mockMvc.perform(post("/library/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userBean))).andExpect(status().is(200));

	}
	
	@Test
	void testUpdateUser() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		UserBean userBean=new UserBean();
		userBean.setEmail("okay");
		userBean.setName("yes");
		userBean.setUsername("Sub");
		mockMvc.perform(put("/library/users/{username}",1).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(userBean))).andExpect(status().is(200));

	}
	
	@Test
	void testGetUsersProfile() throws Exception {
		mockMvc.perform(get("/library/users/{username}",1)).andExpect(status().is(200));
	}
	
	@Test
	void testBookIssue() throws Exception
	{
		BookBean bookBean=new BookBean();
		doReturn(ResponseEntity.ok(bookBean)).when(bookClient).getBookById(1);
		mockMvc.perform(post("/library/users/{username}/books/{bookId}","Sub",1)).andExpect(status().is(201));

	}
	
	@Test
	void testDeleteUserProfile() throws Exception
	{
		mockMvc.perform(delete("/library/users/{username}",1)).andExpect(status().is(204));

	}
	
	@Test
	void testRemoveBookFromUser() throws Exception
	{
		mockMvc.perform(delete("/library/users/{username}/books/{bookId}","Sub",1)).andExpect(status().is(204));

	}
	

}
