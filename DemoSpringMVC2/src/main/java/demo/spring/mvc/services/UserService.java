package demo.spring.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.mvc.entities.UserEntity;
import demo.spring.mvc.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<UserEntity> FindAll() {
		
		return userRepo.findAll();
	}

	public UserEntity FindOne(int userId) {

		return userRepo.FindOne(userId);
		
	}
	
	public UserEntity FindOne(String username) {

		return userRepo.FindOne(username);
		
	}


	public boolean Add(String username, String password, String email) {
	
		return userRepo.Add(username, password, email);
	
	}

	public boolean Delete(int userId) {
	
		return userRepo.Delete(userId);
	}

	public boolean Update(int userId, String username,String password,String email) {

		return userRepo.Update(userId, username,password,email);
	}
}
