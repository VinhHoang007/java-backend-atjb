package general.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import general.spring.mvc.services.LichTrinhXeService;

@Controller
public class LichTrinhXeController {
	
	@Autowired
	LichTrinhXeService lichTrinhXeService;
	
	@GetMapping("/listLichTrinhXe")
	public String showLichTrinhAddXe(Model model) {
		List<Object[]> lst = lichTrinhXeService.getLichTrinhXe();
		model.addAttribute("lichTrinhXe");
		return "addXe";
	}
	
	
}
