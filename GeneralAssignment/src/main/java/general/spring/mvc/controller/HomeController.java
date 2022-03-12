package general.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import general.spring.mvc.entities.Customer;

@Controller
public class HomeController {
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String showLogin(Model model) {
		return "Home";
	}
	
	@RequestMapping(value = { "/sample"}, method = RequestMethod.GET)
	public String showSampleForm(Model model) {

		model.addAttribute("updateCustomer", new Customer());
		model.addAttribute("customer", new Customer());
		
		return "sampleForm";
	}
	

}
