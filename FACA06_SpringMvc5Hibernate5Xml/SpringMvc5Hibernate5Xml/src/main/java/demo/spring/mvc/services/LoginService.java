package demo.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.mvc.repositories.LoginRepository;

@Service
public class LoginService {
    
    @Autowired
    LoginRepository loginRepository;
    
    public boolean checkLoginAdmin(String username, String password) {
        // Logic Here
        return loginRepository.checkLoginAdmin(username, password);
    }
    
    public boolean checkLoginUser(String username, String password) {
        // Logic Here
        return loginRepository.checkLoginUser(username, password);
    }
}
