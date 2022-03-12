package cms.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.spring.mvc.entities.Member;
import cms.spring.mvc.services.MemberServices;



@Controller
public class LoginController {
	@Autowired // quet bean va init variable
	MemberServices memberServices;

		
	@RequestMapping(value = { "/","/login" }, method = RequestMethod.GET)
	public String showLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(path= {"/checkLogin"},method = {RequestMethod.POST})
	public String checkLogin(@ModelAttribute("member") Member mem
			,HttpServletRequest request, Model model){
		
		HttpSession session = request.getSession();
		Member userCheck = memberServices.findOneUserLogin(mem.getEmail());
		
		if(userCheck!= null && userCheck.getPassWord().equals(mem.getPassWord())) {
			session.setAttribute("userLogin", userCheck);

			return "redirect:" +"/viewContent";
		}
		
		model.addAttribute("messageErrorLogin", "Username or password invalid!!!");
		return "login";
	}
}
