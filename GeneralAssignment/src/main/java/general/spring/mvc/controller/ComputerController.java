package general.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import general.spring.mvc.entities.Computer;
import general.spring.mvc.services.ComputerService;

@Controller
@RequestMapping("/Computer")
public class ComputerController {
	@Autowired
	ComputerService computerService;
	

	@GetMapping("/showCreateComputer")
	public String showCreateComputer() {
		return "CreateComputer";
	}
	
	@GetMapping("/showListComputer")
	public String showListComputer(Model model,@RequestParam(name = "index",required = false) Integer index) {
//		List<Computer> lst = computerService.getAllComputerList();
//		model.addAttribute("lstComputer",lst);
		
		if(index == null) {index = 1;}
		
		List<Computer> lst = computerService.getPagingList(index,2);
		model.addAttribute("lstComputer",lst);
		
		
		int numberPage = computerService.numberOfPage(2);
		model.addAttribute("indexPage",index);
		model.addAttribute("numberPage", numberPage);
		
		if(index>numberPage) {
			model.addAttribute("next", numberPage);
		}else {
			model.addAttribute("next", index+1);
		}

		if(index<=1) {
			model.addAttribute("previous", 1);
		}else {
			model.addAttribute("previous", index-1);
		}
		
		return "ListComputer";
	}
	
	@PostMapping("/CreateComputer")
	public String CreateComputer(@ModelAttribute("computer") Computer computer) {
		
		computerService.saveComputer(computer);
		return "redirect:"+"/Computer/showListComputer";
	}
	
	
//	@GetMapping("/deleteComputer")
//	public String CreateComputer(@RequestParam("computerID") int comID) {
//		
//		computerService.deleteComputer(comID);
//		return "redirect:"+"/Computer/showListComputer";
//	}
	@GetMapping("/deleteComputer/{id}")
	public String CreateComputer(@PathVariable("id") int comID) {
		
		computerService.deleteComputer(comID);
		return "redirect:"+"/Computer/showListComputer";
	}
	
	@GetMapping("/showUpdateComputer")
	public String showUpdateComputer(Model model,@RequestParam("computerID") int comID) {
		
		List<Computer> lst = computerService.getAllComputerList();
		model.addAttribute("lstComputer",lst);
		
		Computer comShowUpdate = computerService.findComputerByID(comID);
		model.addAttribute("comShowUpdate",comShowUpdate);
				
		return "ListComputer";
	} 
	
	@PostMapping("/updateComputer")
	public String updateComputer(@ModelAttribute("updateComputer") Computer updateComputer) {
		computerService.updateComputer(updateComputer);
		return "redirect:"+"/Computer/showListComputer";
	}
	
	@GetMapping("/searchComputer")
	public String serchCustomer(@RequestParam(name = "status", required = false) String comName, Model model) {
		
		List<Computer> lstPost=computerService.searchComputer(comName);
		model.addAttribute("listComSearch", lstPost);
			
		return "ListComputer";
	}
}
