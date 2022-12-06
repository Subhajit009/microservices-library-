package com.epam.user.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epam.user.database.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	Optional<UserEntity> findByUsername(String username);
	Optional<UserEntity> deleteByUsername(String username);

}
