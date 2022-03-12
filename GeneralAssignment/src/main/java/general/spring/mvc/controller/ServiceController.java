package general.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import general.spring.mvc.entities.Services;
import general.spring.mvc.services.ServiceService;

@Controller
@RequestMapping("/Service")
public class ServiceController {
	@Autowired
	ServiceService service;
	
	@GetMapping("/showCreateService")
	public String showCreateService() {
		return "CreateService";
	}
	
	@GetMapping("/showListService")
	public String showListService(Model model,@RequestParam(name = "index",required = false) Integer index) {
//		List<Services> lst = service.getAllServiceList();
//		model.addAttribute("lstService",lst);
		
		if(index == null) {index = 1;}
		
		List<Services> lst = service.getPagingList(index,2);
		model.addAttribute("lstService",lst);
		
		int numberPage = service.numberOfPage(2);
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
		
		return "ListService";
	}
	
	@PostMapping("/CreateService")
	public String CreateService(@ModelAttribute("services") Services ser) {
		service.saveService(ser);
		return "redirect:"+"/Service/showListService";
	}
	
	@GetMapping("/deleteService")
	public String deleteService(@RequestParam("serviceID") String serID) {
		System.out.println(serID);
		service.deleteService(serID);
		return "redirect:"+"/Service/showListService";
	}
	
	@GetMapping("/showUpdateService")
	public String showUpdateCustomer(Model model,@RequestParam("serviceID") String comID) {
		
		List<Services> lst = service.getAllServiceList();
		model.addAttribute("lstService",lst);
		
		Services serShowUpdate = service.findServicerByID(comID);
		model.addAttribute("serShowUpdate",serShowUpdate);
		
		return "ListService";
	} 
	
	@PostMapping("/updateService")
	public String updateCustomer(@ModelAttribute("updateService") Services updateService) {
		service.updateService(updateService);
		return "redirect:"+"/Service/showListService";
	}
	
	@GetMapping("/searchService")
	public String serchService(@RequestParam(name = "serviceName", required = false) String serviceName, Model model) {
		
		List<Services> lstPost=service.searchService(serviceName);
		model.addAttribute("listSerSearch", lstPost);
			
		return "ListService";
	}
}
