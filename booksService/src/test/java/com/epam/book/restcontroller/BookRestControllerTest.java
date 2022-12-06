package com.epam.book.restcontroller;

import static org.mockito.ArgumentMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.book.dto.BookDto;
import com.epam.book.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookRestController.class)
class BookRestControllerTest {
	
	@MockBean
	BookService bookService;
	
	@Autowired
	MockMvc mockMvc;
	

	@Test
	void testgetBooks() throws Exception {
		mockMvc.perform(get("/books")).andExpect(status().is(200));
	}

	@Test
	void testgetBookById() throws Exception
	{
		mockMvc.perform(get("/books/{book_id}",1)).andExpect(status().is(200));

	}
	@Test
	void testInsertBooks() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		BookDto bookDto=new BookDto();
		bookDto.setAuthor("I am");
		bookDto.setName("this is");
		bookDto.setPublisher("yess d");
		
		//doNothing().when(bookService).insertBook(any(BookDto.class));
		mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookDto))).andExpect(status().is(201));

	}
	
	@Test
	void testDeleteBook() throws Exception
	{
		mockMvc.perform(delete("/books/{book_id}",1)).andExpect(status().is(204));

	}
	
	@Test
	void testUpdateBook() throws Exception
	{
		ObjectMapper objectMapper=new ObjectMapper();
		BookDto bookDto=new BookDto();
		bookDto.setAuthor("I am");
		bookDto.setName("this is");
		bookDto.setPublisher("yess d");
		mockMvc.perform(put("/books/{book_id}",1).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookDto))).andExpect(status().is(200));

	}
	
	
}
