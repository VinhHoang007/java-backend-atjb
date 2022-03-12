package com.example.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.springboot.entities.LoaiXe;
import com.example.demo.springboot.entities.NhaXe;
import com.example.demo.springboot.entities.TuyenXe;
import com.example.demo.springboot.services.LoaiXeService;
import com.example.demo.springboot.services.NhaXeService;
import com.example.demo.springboot.services.TuyenXeService;
import com.example.demo.springboot.services.XeService;

@Controller
public class HomeController {
	@Autowired
	XeService xeService;
	@Autowired
	NhaXeService nhaXeService;
	@Autowired
	TuyenXeService tuyenXeService;
	@Autowired
	LoaiXeService loaiXeService;
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String showLogin(Model model) {
		LoaiXe lx1 = new LoaiXe("honda",4);
		LoaiXe lx2 = new LoaiXe("toyota",7);
		LoaiXe lx3 = new LoaiXe("huyndai",50);
		LoaiXe lx4 = new LoaiXe("civic",7);
				
		NhaXe nx1 = new NhaXe("Thanh Buoi",1999);
		NhaXe nx2 = new NhaXe("Long Thanh",1999);
		NhaXe nx3 = new NhaXe("Mai Linh",2000);
		
		TuyenXe tx1 = new TuyenXe("Hue Ha Noi",500000);
		TuyenXe tx2 = new TuyenXe("Hue Da Nang",100000);
		TuyenXe tx3 = new TuyenXe("Hue Sai Gon",800000);
		
		loaiXeService.save(lx1);
		loaiXeService.save(lx2);
		loaiXeService.save(lx3);
		loaiXeService.save(lx4);
		
		nhaXeService.saveNhaXe(nx1);
		nhaXeService.saveNhaXe(nx2);
		nhaXeService.saveNhaXe(nx3);
		
		tuyenXeService.saveTuyenXe(tx1);
		tuyenXeService.saveTuyenXe(tx2);
		tuyenXeService.saveTuyenXe(tx3);

		return "index";
	}
	
	

}
