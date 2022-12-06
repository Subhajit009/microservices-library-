package com.epam.library.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.epam.library.database.LibraryEntity;
import com.epam.library.dto.BookBean;
import com.epam.library.repository.LibraryRepository;


@ExtendWith(MockitoExtension.class)
class LibraryServiceTest {

	@Mock
	LibraryRepository libraryRepository;
	
	@InjectMocks
	LibraryService libraryService;
	
	@Test
	void testGetAllUsers() {
		LibraryEntity libraryEntity=new LibraryEntity();
		libraryEntity.setBookId(1);
		libraryEntity.setBookName("adsd");
		libraryEntity.setUsername("me");
		List<LibraryEntity> library=new ArrayList<>();
		library.add(libraryEntity);
		doReturn(library).when(libraryRepository).findByUsername("me");
		assertEquals(library, libraryService.getUserDetails("me"));
	}
	
	@Test
	void testIssueBook()
	{
		BookBean bookBean=new BookBean();
		bookBean.setAuthor("abc");
		bookBean.setName("myself");
		bookBean.setPublisher("this");
		
		libraryService.issueBook("my", bookBean);
		verify(libraryRepository).save(any(LibraryEntity.class));

	}
	
	@Test
	void testDeleted() {
		
		
		LibraryEntity libraryEntity=new LibraryEntity();
		libraryEntity.setBookId(1);
		libraryEntity.setBookName("adsd");
		libraryEntity.setUsername("me");
		
		doReturn(List.of(libraryEntity)).when(libraryRepository).findByUsername("me");
		libraryService.remove("me");
		verify(libraryRepository).delete(any(LibraryEntity.class));
	}
	
	@Test
	void testDeletedBook() {
		
		
		LibraryEntity libraryEntity=new LibraryEntity();
		libraryEntity.setBookId(1);
		libraryEntity.setBookName("adsd");
		libraryEntity.setUsername("me");
		
		doReturn(List.of(libraryEntity)).when(libraryRepository).findByUsername("me");
		libraryService.removeBook("me",1);
		verify(libraryRepository).delete(any(LibraryEntity.class));
	}
	

}
