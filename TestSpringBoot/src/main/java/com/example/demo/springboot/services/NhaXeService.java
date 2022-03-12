package com.example.demo.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springboot.entities.NhaXe;
import com.example.demo.springboot.repositories.NhaXeRepository;
@Service
public class NhaXeService {
	@Autowired
	NhaXeRepository nhaXeRepository;
	
	public void saveNhaXe(NhaXe tx) {
		nhaXeRepository.save(tx);
	}
}
