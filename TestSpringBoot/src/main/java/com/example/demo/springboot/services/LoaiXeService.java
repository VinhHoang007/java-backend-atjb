package com.example.demo.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springboot.entities.LoaiXe;
import com.example.demo.springboot.repositories.LoaiXeRepository;
@Service
public class LoaiXeService {
	@Autowired
	LoaiXeRepository loaiXeRepository;
	
	public LoaiXe save(LoaiXe tx) {
		return loaiXeRepository.save(tx);
	}
}
