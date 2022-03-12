package com.example.demo.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.Userdto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class UserController {
	@Autowired 
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("user", new User());
//		userService.findAll();
		return "index";
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public String show(@PathVariable("id") int id,@Valid @ModelAttribute("user") Userdto user, BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "index";
		}
		
		
		return "redirect:/admin/user/quanli";
	}
	
	@RequestMapping(value = "/user/quanli", method = RequestMethod.GET)
	public String admin(Model model) {
//		userService.findAll();
		User user = userService.findByName("nhat");
		model.addAttribute("user", user);
		return "admin/user/viewAdmin";
	}
	
	
}
