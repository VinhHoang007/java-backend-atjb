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

import general.spring.mvc.entities.Customer;
import general.spring.mvc.services.CustomerService;

@Controller
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/showCreateCustomer")
	public String showCreateCustomer() {
		return "CreateCustomer";
	}
	
	@GetMapping("/showListCustomer")
	public String showListCustomer(Model model,@RequestParam(name = "index",required = false) Integer index) {
//		List<Customer> lst = customerService.getAllCustomerList();
//		model.addAttribute("lstCustomer",lst);
		
		if(index == null) {index = 1;}
		
		List<Customer> lst = customerService.getPagingList(index,2);
		model.addAttribute("lstCustomer",lst);
		
		
		int numberPage = customerService.numberOfPage(2);
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
		
		return "ListCustomer";
	}
	
	@GetMapping("/showListCustomerDetail")
	public String showListCustomerDetail(Model model,@RequestParam(name = "index",required = false) Integer index) {
		
//		List<Customer> lst = customerService.getAllCustomerList();
//		model.addAttribute("lstCustomer",lst);
		
		if(index == null) {index = 1;}
		
		List<Object[]> lst = customerService.getPagingListDetail(index,4);
		model.addAttribute("lstCustomer",lst);
		
		List<Object[]> lstMoney = customerService.getTotalMoneyServiceDetail();
		model.addAttribute("lstMoney",lstMoney);

		int numberPage = customerService.numberOfPageDetail(4);
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
		
		return "ListCustomerDetail";
	}
	
	@PostMapping("/CreateCustomer")
	public String CreateCustomer(Model model,@ModelAttribute("customer") Customer cust) {
		
		if(customerService.isCustomerIdDuplicate(cust.getCustomerID())) {
			model.addAttribute("messageErrIdDuplicate","Trung CustomerID");
			return "CreateCustomer";
		}else {
			customerService.saveCustomer(cust);
			return "redirect:"+"/Customer/showListCustomer";
		}	
	}
	
	@GetMapping("/deleteCustomer")
	public String CreateComputer(@RequestParam("customerID") String comID) {

		customerService.deleteCustomer(comID);
		return "redirect:"+"/Customer/showListCustomer";
	}
	
	@GetMapping("/showUpdateCustomer")
	public String showUpdateCustomer(Model model,@RequestParam("customerID") String comID) {
		
		List<Customer> lst = customerService.getAllCustomerList();
		model.addAttribute("lstCustomer",lst);
		
		Customer custShowUpdate = customerService.findCustomerByID(comID);
		model.addAttribute("custShowUpdate",custShowUpdate);
		model.addAttribute("listCustSearchDetail", null);
		return "ListCustomer";
	} 
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("updateCustomer") Customer updateCustomer) {
		customerService.updateCustomer(updateCustomer);
		return "redirect:"+"/Customer/showListCustomer";
	}
	
	@GetMapping("/searchCustomer")
	public String serchCustomer(@RequestParam(name = "customerName", required = false) String custName, Model model) {
		
		List<Customer> lstPost=customerService.searchCustomer(custName);
		model.addAttribute("listCustSearch", lstPost);
			
		return "ListCustomer";
	}
	
	@GetMapping("/searchCustomerDetail")
	public String serchCustomerDetail(@RequestParam(name = "customerName", required = false) String custName, Model model) {
		
		List<Object[]> lstPost=customerService.searchCustomerDetail(custName);
		model.addAttribute("listCustSearchDetail", lstPost);
		
		List<Object[]> lstMoney = customerService.getTotalMoneyServiceDetail();
		model.addAttribute("lstMoney",lstMoney);
			
		return "ListCustomerDetail";
	}
}
