package com.example.demo.springboot.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.springboot.entities.Xe;
import com.example.demo.springboot.services.XeService;

@Controller
public class AddXeController {
	@Autowired
	XeService xeService;
	
	@GetMapping("/addXe")
	public String showAddXe(Model model) {
		model.addAttribute("xe",new Xe());
		return "addXe";
	}
	
	@PostMapping("/addXe")
	public String AddXe(@ModelAttribute("xe") Xe xe,Model model) {
		
		LocalDate changFormat = LocalDate.parse(xe.getHanKiemDinh());
		System.out.println(ChronoUnit.DAYS.between(changFormat, LocalDate.now()));
		if(ChronoUnit.DAYS.between(LocalDate.now(),changFormat)>30) {
			xeService.saveXe(xe);
		}else {
			model.addAttribute("messageErrDate", "SAI Format HanKiemDinh");
			return "addXe";
		}
		return "redirect:"+ "/addXe";
		
	}
	

}
