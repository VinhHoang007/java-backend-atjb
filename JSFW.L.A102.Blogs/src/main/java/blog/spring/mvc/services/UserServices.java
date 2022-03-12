package blog.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.spring.mvc.entities.UserEntity;
import blog.spring.mvc.repositories.UserRepository;


@Service

public class UserServices {
	@Autowired
	UserRepository userRepo;
	
	public UserEntity findOneUserLogin(String userName) {

		return userRepo.findOne(userName);
		
	}
	
	public void saveUsers(UserEntity user) {

		userRepo.saveUsers(user);
		
	}
}
