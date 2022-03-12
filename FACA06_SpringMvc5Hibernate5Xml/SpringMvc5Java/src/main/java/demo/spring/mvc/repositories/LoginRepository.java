package demo.spring.mvc.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    public boolean checkLoginAdmin(String username, String password) {
        // Logic Here
        return "admin".equals(username) && "admin".equals(password);
    }
    
    public boolean checkLoginUser(String username, String password) {
        // Logic Here
        return "user".equals(username) && "user".equals(password);
    }
}
