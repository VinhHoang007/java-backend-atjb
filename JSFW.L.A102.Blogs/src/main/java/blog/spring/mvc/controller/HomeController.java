package blog.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import blog.spring.mvc.entities.CommentEntity;
import blog.spring.mvc.entities.PostEntity;
import blog.spring.mvc.services.CommentServices;
import blog.spring.mvc.services.PostServices;

@Controller
public class HomeController {
	@Autowired
	PostServices postServices;
	
	@Autowired
	CommentServices commentServices;
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String index(Model model, @RequestParam(name = "index",required = false) Integer index) {
		
//		List<PostEntity> lstAllPost = postServices.getAllPostList();
		if(index == null) {index = 1;}
		List<PostEntity> lstAllPost = postServices.getPagingList(index,2);

		List<CommentEntity> lstAllCmt = commentServices.getAllComments();
		
		int numberPage = postServices.numberOfPage(2);
		model.addAttribute("indexPage",index);
		model.addAttribute("numberPage", numberPage);
		model.addAttribute("listAllPost", lstAllPost);
		model.addAttribute("listAllComment", lstAllCmt);
		
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
		
		
		return "home";
	}
	
//	@RequestMapping(value = { "/paging" }, method = RequestMethod.GET)
//	public String paging(Model model, @RequestParam("index") int index) {
//		
//		List<PostEntity> lstAllPost = postServices.getPagingList(index,2);
//		model.addAttribute("listAllComment", lstAllPost);
//		return "home";
//	}
	
}
