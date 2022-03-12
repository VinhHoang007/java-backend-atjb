package cms.spring.mvc.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cms.spring.mvc.entities.Member;
import cms.spring.mvc.services.MemberServices;

@Controller
public class RegisterController {
	@Autowired
	MemberServices memberServices;

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String showRegister(Model model) {
		if (!model.containsAttribute("memberRegis")) {
			model.addAttribute("memberRegis", new Member());
		}
		return "register";
	}
	
	@RequestMapping(value = { "/saveMember" }, method = RequestMethod.POST)
	public String saveMember(@ModelAttribute("memberRegis") @Validated   Member memberRegis,
			BindingResult result) {

		if (result.hasErrors()) {
			for (ObjectError objectError: result.getAllErrors()) {
				System.out.println(objectError);
				System.out.println(objectError.getCode());
			}
			
		}else {
			memberRegis.setCreateDate(LocalDateTime.now());
			memberServices.saveUsers(memberRegis);
			return "redirect:" + "/login";
		}
		return "register";
	}
}
