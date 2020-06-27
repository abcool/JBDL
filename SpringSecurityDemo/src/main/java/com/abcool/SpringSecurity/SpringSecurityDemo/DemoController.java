package com.abcool.SpringSecurity.SpringSecurityDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

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
}
