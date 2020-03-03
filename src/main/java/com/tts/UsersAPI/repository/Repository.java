package com.tts.UsersAPI.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts.UsersAPI.model.User;

public interface Repository extends CrudRepository<User, Long> {

	List<User> findByState(String state);
}
