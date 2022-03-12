package com.example.demo.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.springboot.entities.LoaiXe;

@Repository
public interface LoaiXeRepository extends JpaRepository<LoaiXe, Integer> {

}
