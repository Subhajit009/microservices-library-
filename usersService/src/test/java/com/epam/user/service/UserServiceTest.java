package com.epam.user.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.user.database.UserEntity;
import com.epam.user.dto.UserDto;
import com.epam.user.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	UserRepository userRepository;

	
	@InjectMocks
	UserService userService;
	
	
	@Test
	void testGetAllUsers() {
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail("Abc");
		userEntity.setName("yess");
		userEntity.setUsername("this is");
		List<UserEntity> users=new ArrayList<>();
		users.add(userEntity);
		doReturn(users).when(userRepository).findAll();
		assertEquals(users, userService.getAllUser());
	}
	
	@Test
	void testGetUserById() {
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail("Abc");
		userEntity.setName("yess");
		userEntity.setUsername("this is");
		//List<BookEntity> books=new ArrayList<>();
		//books.add(bookEntity);
		doReturn(Optional.of(userEntity)).when(userRepository).findByUsername("this is");
		assertEquals(userEntity, userService.getUserByUsername("this is"));
	}
	
	@Test
	void testInsertBooks() {
		
		UserDto userDto=new UserDto();
		userDto.setEmail("Abc");
		userDto.setName("yess");
		userDto.setUsername("this is");
		
//		UserEntity userEntity=new UserEntity();
//		userEntity.setEmail("Abc");
//		userEntity.setName("yess");
//		userEntity.setUsername("this is");
		
		userService.insertUser(userDto);
		verify(userRepository).save(any(UserEntity.class));
		//verify(userRepository).save(userEntity);
	}
	
	@Test
	void testDeleteBooks() {
		
		
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail("Abc");
		userEntity.setName("yess");
		userEntity.setUsername("this is");
		
		doReturn(Optional.of(userEntity)).when(userRepository).findByUsername("this is");
		userService.remove("this is");
		verify(userRepository).delete(any(UserEntity.class));
	}
	
	@Test
	void testUpdateUser() {
		
		UserDto userDto=new UserDto();
		userDto.setEmail("Abc");
		userDto.setName("yess");
		userDto.setUsername("this is");
		
		UserEntity userEntity=new UserEntity();
		userEntity.setEmail("Abc");
		userEntity.setName("yess");
		userEntity.setUsername("this is");
		
		doReturn(Optional.of(userEntity)).when(userRepository).findByUsername("this is");

		//when(bookRepository.save(bookEntity)).thenReturn(bookEntity);
		userService.updateUser("this is",userDto);
		verify(userRepository).save(any(UserEntity.class));
	}
	
	
	

}
