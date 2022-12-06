package com.epam.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epam.library.database.LibraryEntity;
import com.epam.library.dto.BookBean;
import com.epam.library.dto.UserBean;
import com.epam.library.repository.LibraryRepository;
@Service
public class LibraryService {

	@Autowired
	LibraryRepository libraryRepository;
	
	
	public List<LibraryEntity> getUserDetails(String username){
		return libraryRepository.findByUsername(username);
		
	}
	
	
	public void issueBook(String username,BookBean book) {
		LibraryEntity libraryEntity=new LibraryEntity();
		libraryEntity.setUsername(username);
		libraryEntity.setBookId(book.getId());
		libraryEntity.setBookName(book.getName());
		libraryRepository.save(libraryEntity);
	}
	
	public void remove(String username) {
		List<LibraryEntity> users= libraryRepository.findByUsername(username);
		for(LibraryEntity u:users) {
			libraryRepository.delete(u);
		}
	}

	public void removeBook(String username,int id) {
		List<LibraryEntity> users= libraryRepository.findByUsername(username);
		for(LibraryEntity u:users) {
			if(u.getBookId()==id) {
				libraryRepository.delete(u);
				break;
			}
		}
	}
}
