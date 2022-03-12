package blog.spring.mvc.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.spring.mvc.entities.CommentEntity;
import blog.spring.mvc.services.CommentServices;
@Controller
public class CommentController {
	@Autowired
	CommentServices commentServices;
	
	@PostMapping("/saveComment")
	public String saveComments(@ModelAttribute("commentAttr") CommentEntity commentEntity,
			@RequestParam("postID") int postID) {
		
		commentEntity.setPostID(postID);
		commentEntity.setStatus(1);
		commentEntity.setCreateTime(LocalDateTime.now());
		System.out.println(commentEntity);
		commentServices.saveComments(commentEntity);
		
		return "redirect:/home";

	}
}
