package general.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import general.spring.mvc.entities.Customer;
import general.spring.mvc.entities.ServiceUsage;
import general.spring.mvc.entities.Services;
import general.spring.mvc.services.CustomerService;
import general.spring.mvc.services.ServiceService;
import general.spring.mvc.services.ServiceUsageService;

@Controller
@RequestMapping("/ServiceUsage")

public class ServiceUsageController {
	
	@Autowired
	ServiceService serviceService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ServiceUsageService serviceUsageService ;
	
	@GetMapping("/showRegisterService")
	public String showRegisterService(Model model) {
		List<Customer> lstCustomer = customerService.getAllCustomerList();
		model.addAttribute("lstCustomer",lstCustomer);
		
		List<Services> lstService = serviceService.getAllServiceList();
		model.addAttribute("lstService",lstService);
		
		return "CreateRegisterService";
	
	}
	
	@PostMapping("/CreateServiceUsage")
	public String CreateComputer(@ModelAttribute("serviceUsage") ServiceUsage ser) {
		serviceUsageService.saveServiceUsage(ser);
		return "redirect:"+"/Customer/showListCustomerDetail";
	}
	
}
