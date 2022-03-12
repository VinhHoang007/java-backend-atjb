package demo.spring.mvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.mvc.services.LoginService;

@Controller
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        System.out.println("LoginController - showLogin");
        
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogin(HttpSession session, Model model, String username, String password) {
        System.out.println("LoginController - checkLogin");
        
        if(loginService.checkLoginAdmin(username, password)) {
            session.setAttribute("usernamelogin", username);
            session.setAttribute("rolelogin", "admin");
            // redirect tới trang cần : home admin 
            return "redirect:/admin/";
        }else if (loginService.checkLoginUser(username, password)) {
         // redirect tới trang cần : home user
            session.setAttribute("usernamelogin", username);
            session.setAttribute("rolelogin", "user");
            return "redirect:/";
        }
        
        model.addAttribute("message", "Username or Password is Invalid !!!");
        return "login";
    }
}
