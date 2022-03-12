package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired 
	private UserService userService;

	@RequestMapping(value = "/hello")
	public String hello(Model model) {
		User user = new User(1, "nhat", "nhat1", "1234");
		
		userService.save(user);
//
		return "index";
	}
}
