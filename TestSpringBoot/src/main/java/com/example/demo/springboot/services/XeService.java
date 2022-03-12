package com.example.demo.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.springboot.entities.Xe;
import com.example.demo.springboot.repositories.XeRepository;

@Service
public class XeService {
	@Autowired
	XeRepository xeRepository;
	
	public void saveXe(Xe tx) {
		xeRepository.save(tx);
	}
}
