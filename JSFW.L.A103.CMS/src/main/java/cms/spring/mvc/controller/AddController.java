package cms.spring.mvc.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.spring.mvc.entities.Content;
import cms.spring.mvc.entities.Member;
import cms.spring.mvc.services.ContentServices;

@Controller
public class AddController {
	@Autowired
	ContentServices contentServices;
	
	@RequestMapping(value = { "/showAddContent" }, method = RequestMethod.GET)
	public String showAddContent(Model model) {
		return "addcontent";
	}
	
	@RequestMapping(value = { "/addContent" }, method = RequestMethod.POST)
	public String addContent(Model model,@ModelAttribute("content") Content cont,HttpServletRequest request ) {
		System.out.println(cont);
		Member mem = (Member) request.getSession().getAttribute("userLogin");
		
		cont.setAuthorID(mem.getId());
		cont.setCreateDate(LocalDateTime.now());
		
		contentServices.saveContent(cont);
		return "redirect:"+ "/viewContent";
	}
}
