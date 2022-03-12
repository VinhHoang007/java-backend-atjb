package demo.spring.mvc.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.spring.mvc.entities.UserEntity;
import demo.spring.mvc.services.UserService;


@Controller
public class LoginController {
	public LoginController() {
		System.out.println("LoginController");
	}
	@RequestMapping(path= {"/login"},method = {RequestMethod.GET})
	public String showLogin() {
		return "login"; // /WEB-INF/views/login.jsp
	}
	@Autowired // quet bean va init variable
	UserService userService;
	@RequestMapping(path= {"/login"},method = {RequestMethod.POST})
	public String checkLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		UserEntity userInfor = userService.FindOne(username);

		
		if(userInfor!= null && userInfor.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("LoginUserName", userInfor.getUserName());
			
			return "redirect:" /*+ req.getContextPath() */+ "/admin/user/list";
		}
		
		req.setAttribute("messageServer", "Username or password invalid!!!");
		return "login";
	}
	
	@RequestMapping(path= {"/logout"},method = {RequestMethod.POST})
	public String logout(HttpSession session) throws IOException {
		
		session.removeAttribute("LoginUserName");
		session.invalidate();
		
		return "/login";
		
	}
}
