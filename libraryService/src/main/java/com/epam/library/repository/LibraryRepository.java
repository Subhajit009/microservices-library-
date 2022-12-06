package com.epam.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epam.library.database.LibraryEntity;

public interface LibraryRepository extends CrudRepository<LibraryEntity, Integer>{
	List<LibraryEntity> findByUsername(String username);
//	LibraryEntity deleteByUsername(String username);
	//Optional<LibraryEntity> FindByBookid(int bookId);
}
