package blog.spring.mvc.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.spring.mvc.entities.CommentEntity;
import blog.spring.mvc.entities.PostEntity;
import blog.spring.mvc.entities.UserEntity;
import blog.spring.mvc.services.CommentServices;
import blog.spring.mvc.services.PostServices;
import blog.spring.mvc.services.UserServices;


	@Controller
	
	public class IndexController {
		@Autowired // quet bean va init variable
		UserServices userService;
		
		@Autowired // quet bean va init variable
		PostServices postServices;
		
		@Autowired // quet bean va init variable
		CommentServices commentServices;
		
		@RequestMapping(value = { "/"}, method = RequestMethod.GET)
		public String index(Model model) {
//			UserEntity user1 = new UserEntity("kross","123","Thieu Muoi","k1@gmail.com","none");
//			UserEntity user2 = new UserEntity("kaka","123","Thieu Muoi","k2@gmail.com","none");
//			UserEntity user3 = new UserEntity("ronaldo","123","Thieu Muoi","k3@gmail.com","none");
//			
//			userService.saveUsers(user1);
//			userService.saveUsers(user2);
//			userService.saveUsers(user3);
//			
//			PostEntity post1 = new PostEntity("WelCome", 
//					"Lorem ipsum dolor, sit amet consectetur adipisicing elit. "
//					+ "Porro quas ex vitae beatae, ducimus. Deleniti sed ipsa quo "
//					+ "officiis obcaecati debitis molestiae officia, delectus vero."
//					, "Draft", "test",LocalDateTime.now(), null, 1);
//			postServices.savePost(post1); 
//			
//			CommentEntity cmt1 = new CommentEntity("Nguyen Van Teo", 
//					"google.com", "t1@gmail.com", "comment cho vui", 1, LocalDateTime.now(),1);
//			
//			commentServices.saveComments(cmt1);
			
			model.addAttribute("messageBlog", "Welcome To Blogs");
			return "index";
		}
	}

