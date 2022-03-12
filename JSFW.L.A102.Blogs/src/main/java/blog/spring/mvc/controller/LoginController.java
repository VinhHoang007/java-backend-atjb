package blog.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.spring.mvc.entities.UserEntity;
import blog.spring.mvc.services.UserServices;



@Controller
public class LoginController {
	@Autowired // quet bean va init variable
	UserServices userService ;

		
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "login";
	}
	
	@RequestMapping(path= {"/checkLogin"},method = {RequestMethod.POST})
	public String checkLogin(@ModelAttribute("user") UserEntity user
			,HttpServletRequest request, Model model){
		
//		System.out.println(user);
		HttpSession session = request.getSession();
		UserEntity userCheck = userService.findOneUserLogin(user.getUserName());
		
		if(userCheck!= null && userCheck.getPassWord().equals(user.getPassWord())) {
			session.setAttribute("userLogin", userCheck);

			return "redirect:" +"/post/showManagePost";
		}
		
		model.addAttribute("messageErrorLogin", "Username or password invalid!!!");
		return "redirect:" +"login";
	}
}
