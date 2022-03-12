package cms.spring.mvc.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cms.spring.mvc.entities.Member;
import cms.spring.mvc.services.MemberServices;

@Controller
public class EditController {
	@Autowired
	MemberServices memberServices;
	
	@RequestMapping(value = { "/showEditProfile" }, method = RequestMethod.GET)
	public String showEditProfile(Model model, HttpServletRequest request) {
		
		Member mem = (Member)request.getSession().getAttribute("userLogin");
		Member memEdit = memberServices.findOneUserLogin(mem.getEmail());
		model.addAttribute("member",memEdit);
		return "editprofile";
	}
	
	@RequestMapping(value = { "/editProfile" }, method = RequestMethod.POST)
	public String editProfile(Model model,@ModelAttribute("profile") Member mem,@RequestParam("id") int id) {
		System.out.println(mem);
		mem.setId(id);
		mem.setUpdateTime(LocalDateTime.now());
		memberServices.updateMember(mem);
		return "redirect:"+ "/showEditProfile";
	}
}