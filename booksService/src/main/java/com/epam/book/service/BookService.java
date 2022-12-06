package com.epam.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.book.database.BookEntity;
import com.epam.book.dto.BookDto;
import com.epam.book.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;

	
	 public List<BookEntity> getAllBooks(){
	    	List<BookEntity> books=(List<BookEntity>) bookRepository.findAll();
	    	return books;
	    }
	 public BookEntity getBookById(int id){
	    	Optional<BookEntity> book = bookRepository.findById(id);
	    	if(!book.isPresent())
	    		return null;
	    	return book.get();
	    }
	 
	 public void insertBook(BookDto bookDto) {
		 
		 BookEntity bookEntity=new BookEntity();
		 
		 bookEntity.setAuthor(bookDto.getAuthor());
		 bookEntity.setName(bookDto.getName());
		 bookEntity.setPublisher(bookDto.getPublisher());
		 bookRepository.save(bookEntity);
		
	}
	 public void remove(int id)
	 {
		 bookRepository.deleteById(id);
	 }
	 
	public void updateBook(int id,BookDto bookDto)
	{
		Optional<BookEntity> bookOptional=bookRepository.findById(id);
		if(bookOptional.isPresent()) {
			bookOptional.get().setAuthor(bookDto.getAuthor());
			bookOptional.get().setName(bookDto.getName());
			bookOptional.get().setPublisher(bookDto.getPublisher());
			bookRepository.save(bookOptional.get());
		}
			
	}

}
