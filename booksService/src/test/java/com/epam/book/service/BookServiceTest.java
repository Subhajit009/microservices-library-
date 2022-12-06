package com.epam.book.service;
import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito.Then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

import com.epam.book.database.BookEntity;
import com.epam.book.dto.BookDto;
import com.epam.book.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	
	@Mock
	BookRepository bookRepository;

	
	@InjectMocks
	BookService bookService;
	
	@Test
	void testGetAllBooks() {
		BookEntity bookEntity=new BookEntity();
		bookEntity.setAuthor("I am");
		bookEntity.setName("this is");
		bookEntity.setPublisher("yess d");
		List<BookEntity> books=new ArrayList<>();
		books.add(bookEntity);
		doReturn(books).when(bookRepository).findAll();
		assertEquals(books, bookService.getAllBooks());
	}

	@Test
	void testGetBookById() {
		BookEntity bookEntity=new BookEntity();
		bookEntity.setAuthor("I am");
		bookEntity.setName("this is");
		bookEntity.setPublisher("yess d");
		//List<BookEntity> books=new ArrayList<>();
		//books.add(bookEntity);
		doReturn(Optional.of(bookEntity)).when(bookRepository).findById(1);
		assertEquals(bookEntity, bookService.getBookById(1));
	}
	
	@Test
	void testInsertBooks() {
		
		BookDto bookDto=new BookDto();
		bookDto.setAuthor("I am");
		bookDto.setName("this is");
		bookDto.setPublisher("yess d");
		
		bookService.insertBook(bookDto);
		verify(bookRepository).save(any(BookEntity.class));
	}
	
	@Test
	void testDeleteBooks() {
		
		BookDto bookDto=new BookDto();
		bookDto.setAuthor("I am");
		bookDto.setName("this is");
		bookDto.setPublisher("yess d");
		
		//when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		bookService.remove(1);
		verify(bookRepository).deleteById(1);
	}
	
	@Test
	void testUpdateBooks() {
		
		BookDto bookDto=new BookDto();
		bookDto.setAuthor("I am");
		bookDto.setName("this is");
		bookDto.setPublisher("yess d");
		
		BookEntity bookEntity=new BookEntity();
		bookEntity.setAuthor("I am");
		bookEntity.setName("this is");
		bookEntity.setPublisher("yess d");
		
		doReturn(Optional.of(bookEntity)).when(bookRepository).findById(1);

		//when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		bookService.updateBook(1,bookDto);
		verify(bookRepository).save(any(BookEntity.class));
	}
	
}
