package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Userdto {

	private Integer id;
	
	@NotBlank(message = "dit me may")
	private String name;

	@NotBlank(message = "username khong duoc trong")
	private String username;


	private String password;
	
}
