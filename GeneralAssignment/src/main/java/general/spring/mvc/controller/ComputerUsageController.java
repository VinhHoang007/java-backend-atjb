package general.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import general.spring.mvc.entities.Computer;
import general.spring.mvc.entities.ComputerUsage;
import general.spring.mvc.entities.Customer;
import general.spring.mvc.services.ComputerService;
import general.spring.mvc.services.ComputerUsageService;
import general.spring.mvc.services.CustomerService;

@Controller
@RequestMapping("/ComputerUsage")
public class ComputerUsageController {
	@Autowired
	ComputerUsageService computerUsageService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ComputerService computerService;
	
	@GetMapping("/showRegisterComputer")
	public String showRegisterService(Model model) {
		List<Customer> lstCustomer = customerService.getAllCustomerList();
		model.addAttribute("lstCustomer",lstCustomer);
		
		List<Computer> lstComputer = computerService.getComputerListAvailable();
		model.addAttribute("lstComputer",lstComputer);
		
		return "CreateRegisterComputer";
	}
	
	@PostMapping("/CreateComputerUsage")
	public String createComputerUsage(@ModelAttribute("computerUsage") ComputerUsage ser) {
		computerUsageService.saveComputerUsage(ser);
		return "redirect:"+"/Customer/showListCustomerDetail";
	}
}
