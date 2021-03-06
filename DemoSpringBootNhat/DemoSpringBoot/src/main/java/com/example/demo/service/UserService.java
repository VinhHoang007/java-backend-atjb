package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public interface UserService {

	List<User> findAll();
	
	User save(User user);
	
	User findByName(String name);
}
