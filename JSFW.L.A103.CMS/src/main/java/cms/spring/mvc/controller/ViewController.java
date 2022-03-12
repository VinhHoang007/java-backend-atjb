package cms.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.spring.mvc.entities.Content;
import cms.spring.mvc.services.ContentServices;

@Controller
public class ViewController {
	@Autowired
	ContentServices contentServices;
	
	@RequestMapping(value = { "/viewContent" }, method = RequestMethod.GET)
	public String showViewContent(Model model) {
		List<Content> lstContent = new ArrayList<Content>();
		lstContent = contentServices.getAllContentList();
		model.addAttribute("lstContent", lstContent);
		return "viewcontent";
	}
	
	
}
