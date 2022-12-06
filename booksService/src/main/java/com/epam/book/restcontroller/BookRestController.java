package com.epam.book.restcontroller;

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

import com.epam.book.database.BookEntity;
import com.epam.book.dto.BookDto;
import com.epam.book.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getBooks()
	{
		return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
	}
	
	@GetMapping("books/{book_id}")
	public ResponseEntity<BookEntity> getBookById(@PathVariable("book_id") int id)
	{
		return new ResponseEntity<>(bookService.getBookById(id),HttpStatus.OK);
	}
	
	@PostMapping("books")
	public ResponseEntity<String> insertBook(@RequestBody BookDto bookDto)
	{
		bookService.insertBook(bookDto);
		return new ResponseEntity<>("Book added!!!",HttpStatus.CREATED);
	}
	
	@DeleteMapping("books/{book_id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("book_id") int id)
	{
		bookService.remove(id);
		 return ResponseEntity.noContent().build();
	}
	
	@PutMapping("books/{book_id}")
	public ResponseEntity<String> updateBook(@PathVariable("book_id") int id,@RequestBody BookDto bookDto)
	{
		bookService.updateBook(id,bookDto);
		return new ResponseEntity<>("Book updated!!!",HttpStatus.OK);
		
	}

}
