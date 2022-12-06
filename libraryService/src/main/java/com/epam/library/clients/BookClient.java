package com.epam.library.clients;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.library.dto.BookBean;


@FeignClient(name="booksService")
@LoadBalancerClient(name = "booksService")
public interface BookClient
{

	@GetMapping("/books")
	public ResponseEntity<List<BookBean>> getBooks();
	
	
	@GetMapping("books/{book_id}")
	public ResponseEntity<BookBean> getBookById(@PathVariable("book_id") int id);
	
	
	@PostMapping("books")
	public ResponseEntity<String> insertBook(@RequestBody BookBean bookDto);
	
	@DeleteMapping("books/{book_id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("book_id") int id);
	
	@PutMapping("books/{book_id}")
	public ResponseEntity<String> updateBook(@PathVariable("book_id") int id,@RequestBody BookBean bookDto);
	
}
