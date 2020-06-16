package com.abcool.RestTemplate.Demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.RestTemplate.Demo.DTOs.RequestDTO;
import com.abcool.RestTemplate.Demo.DTOs.ResponseDTO;
import com.abcool.RestTemplate.Demo.Service.UserService;

@RestController
public class Controller {
	@Autowired
	UserService service;
	
	
	@GetMapping("/gitHub/users/")
	public ResponseDTO getDetails(@RequestBody RequestDTO dto) {
		return service.getDetails(dto);
	}

}
