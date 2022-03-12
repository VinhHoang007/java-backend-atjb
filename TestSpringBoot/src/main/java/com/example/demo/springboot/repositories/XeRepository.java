package com.example.demo.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.springboot.entities.Xe;

@Repository
public interface XeRepository extends JpaRepository<Xe, Integer> {

}
