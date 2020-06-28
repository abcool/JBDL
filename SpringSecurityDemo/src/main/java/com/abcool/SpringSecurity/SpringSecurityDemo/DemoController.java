package com.abcool.SpringSecurity.SpringSecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.SpringSecurity.SpringSecurityDemo.DTOs.DemoRequestDTO;
import com.abcool.SpringSecurity.SpringSecurityDemo.service.UserService;

@RestController
public class DemoController {
	
	@Autowired
	UserService service;

	@GetMapping("/admin")
	public String getHi() {
		return "Hi admin";
	}
	
	@GetMapping("/staff")
	public String staff() {
		return "Hello staff";
	}
	
	@GetMapping("/guest")
	public String guest() {
		return "Welcome guest";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody DemoRequestDTO dto) {
		return service.saveUser(dto);
	}
}
