package com.epam.library.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.library.clients.BookClient;
import com.epam.library.clients.UserClient;
import com.epam.library.database.LibraryEntity;
import com.epam.library.dto.BookBean;
import com.epam.library.dto.UserBean;
import com.epam.library.service.LibraryService;

@RestController
public class LibraryBookController {

	@Autowired
	BookClient bookClient;
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	LibraryService libraryService;
	
	@Autowired
	Environment environment;
	
	@GetMapping("library/books")
	public ResponseEntity<List<BookBean>> getAllBooksFromLibrary(){
		return bookClient.getBooks();
	}
	
	@GetMapping("library/books/{bookId}")
	public ResponseEntity<BookBean> getBookById(@PathVariable("bookId") int id){
		return bookClient.getBookById(id);
	}
	
	@PostMapping("library/books")
	public ResponseEntity<String> insertBook(@RequestBody BookBean bookDto){
		return bookClient.insertBook(bookDto);
	}
	
	@PutMapping("library/books/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable("bookId") int id,@RequestBody BookBean bookDto){
		return bookClient.updateBook(id, bookDto);
	}
	
	@DeleteMapping("library/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int id)
	{
		return bookClient.deleteBook(id);
	}
	
	
	//---------USERS-------------
	
	@GetMapping("library/users")
	public ResponseEntity<List<UserBean>> getUsers(){
		return userClient.getUsers();
	}
	
//	@PostMapping("library/users/{username}")
	@PostMapping("library/users")
	public ResponseEntity<String> insertUser(@RequestBody UserBean userDto)
	{
		return userClient.insertUser(userDto);
	}

	@PutMapping("library/users/{username}")
	public ResponseEntity<String> updateUser(@PathVariable("username") String username,@RequestBody UserBean userDto){
		return userClient.updateUser(username, userDto);
	}

	
	
	
	@GetMapping("library/users/{username}")
	public ResponseEntity<List<LibraryEntity>> getUserProfile(@PathVariable("username") String username){
		return new ResponseEntity<>(libraryService.getUserDetails(username),HttpStatus.OK);	}
	
	
	
	
	
	
	
	
	@PostMapping("/library/users/{username}/books/{bookId}")
	public ResponseEntity<String> bookIssue(@PathVariable("username") String username,@PathVariable("bookId") int bookId){
		ResponseEntity<BookBean> book= bookClient.getBookById(bookId);
		libraryService.issueBook(username,book.getBody());
		return new ResponseEntity<>("Book issued!!!",HttpStatus.CREATED);
	}
	
	@DeleteMapping("library/users/{username}")
	public ResponseEntity<Void> deleteUserProfile(@PathVariable("username") String username){
		 libraryService.remove(username);
//		 userClient.deleteUser(username);
		 return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("library/users/{username}/books/{bookId}")
	public ResponseEntity<Void> removeBookFromUser(@PathVariable("username") String username,@PathVariable("bookId") int bookId){
		libraryService.removeBook(username,bookId);
		return ResponseEntity.noContent().build();
	}
}
