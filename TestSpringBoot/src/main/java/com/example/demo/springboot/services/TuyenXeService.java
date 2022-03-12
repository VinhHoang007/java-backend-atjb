package com.example.demo.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springboot.entities.TuyenXe;
import com.example.demo.springboot.repositories.TuyenXeRepository;

@Service
public class TuyenXeService {
	@Autowired
	TuyenXeRepository tuyenXeRepository;
	
	public void saveTuyenXe(TuyenXe tx) {
		tuyenXeRepository.save(tx);
	}
	
}
