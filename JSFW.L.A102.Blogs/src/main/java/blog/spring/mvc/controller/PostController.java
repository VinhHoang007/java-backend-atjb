package blog.spring.mvc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.spring.mvc.entities.PostEntity;
import blog.spring.mvc.entities.UserEntity;
import blog.spring.mvc.services.PostServices;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostServices postServices;

	@GetMapping("/showCreatePost")
	public String showCreatePost(Model theModel) {
		return "createpost";
	}

	@GetMapping("/showManagePost")
	public String showManagePost(Model theModel, HttpServletRequest request) {

		// Lay Doi Tuong Dang Nhap
		UserEntity user = (UserEntity) request.getSession().getAttribute("userLogin");
		// Danh Sach Bai Post
		List<PostEntity> lstPostEntities = new ArrayList<PostEntity>();
		lstPostEntities = postServices.getPostListByAccount(user.getId());
		theModel.addAttribute("listPost", lstPostEntities);
		return "managepost";
	}

	@PostMapping("/savePost")
	public String savePost(@ModelAttribute("postSave") PostEntity postEntity, HttpServletRequest request) {

		UserEntity userEntity = (UserEntity) request.getSession().getAttribute("userLogin");

		postEntity.setCreateTime(LocalDateTime.now());
		postEntity.setAuthorID(userEntity.getId());
		postServices.savePost(postEntity);
		return "redirect:/post/showManagePost";

	}

	@GetMapping("/deletePost")
	public String deletePost(@RequestParam("postID") int theId) {
		postServices.deletePost(theId);
		return "redirect:/post/showManagePost";
	}

	@GetMapping("/showUpdatePost")
	public String showUpdatePost(@RequestParam("postID") int postID, Model model) {
		PostEntity postEnti = postServices.getPostEntity(postID);
		model.addAttribute("postEntiUp", postEnti);
		model.addAttribute("createTime", postEnti.getCreateTime().toString());
		return "updatepost";
	}

	@PostMapping("/updatePost")
	public String updatePost(@ModelAttribute("postUpdate") PostEntity postEnti,HttpServletRequest request,@RequestParam("oldCreateTime") String createTime) {
		UserEntity userEntity = (UserEntity) request.getSession().getAttribute("userLogin");

		LocalDateTime dateTime = LocalDateTime.parse(createTime);

		postEnti.setCreateTime(dateTime);
		postEnti.setUpdateTime(LocalDateTime.now());
		postEnti.setId(postEnti.getId());
		postEnti.setAuthorID(userEntity.getId());
		
		System.out.println("posE:"+ postEnti);
		postServices.updatePost(postEnti);
		return "redirect:/post/showManagePost";
	}
	
	@GetMapping("/searchPost")
	public String searchPost(@ModelAttribute("searchTitle") PostEntity postEntity, Model theModel
			, HttpServletRequest request) {
		UserEntity user = (UserEntity) request.getSession().getAttribute("userLogin");
		List<PostEntity> lstPost=postServices.searchPost(user.getId(),postEntity.getTitle(),postEntity.getStatus());
		theModel.addAttribute("listPostSearch", lstPost);
		System.out.println(lstPost);
		return "managepost";
	}
}
