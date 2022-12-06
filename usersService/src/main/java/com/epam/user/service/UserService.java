package com.epam.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.user.database.UserEntity;
import com.epam.user.dto.UserDto;
import com.epam.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	
	 public List<UserEntity> getAllUser(){
	    	List<UserEntity> users=(List<UserEntity>) userRepository.findAll();
	    	return users;
	    }
	 public UserEntity getUserByUsername(String username){
	    	Optional<UserEntity> user = userRepository.findByUsername(username);
	    	if(!user.isPresent())
	    		return null;
	    	return user.get();
	    }
	 
	 public void insertUser(UserDto userDto) {
		 
		 UserEntity userEntity=new UserEntity();
		 
		 userEntity.setEmail(userDto.getEmail());
		 userEntity.setUsername(userDto.getUsername());
		 userEntity.setName(userDto.getName());
		 userRepository.save(userEntity);
	}
	 public void remove(String username)
	 {
		 Optional<UserEntity> user = userRepository.findByUsername(username);
		 userRepository.delete(user.get());
	 }
	 
	public void updateUser(String username,UserDto userDto)
	{
		Optional<UserEntity> userOptional=userRepository.findByUsername(username);
		if(userOptional.isPresent()) {
			userOptional.get().setUsername(userDto.getUsername());
			userOptional.get().setEmail(userDto.getEmail());
			userOptional.get().setName(userDto.getName());
			userRepository.save(userOptional.get());
			
		}
			
	}

}
