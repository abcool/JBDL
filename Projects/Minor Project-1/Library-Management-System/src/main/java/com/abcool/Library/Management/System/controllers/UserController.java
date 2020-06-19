package com.abcool.Library.Management.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.Library.Management.System.DTOs.UserRequestDTO;
import com.abcool.Library.Management.System.DTOs.UserResponseDTO;
import com.abcool.Library.Management.System.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping(path="/users", produces="application/json")
	public List<UserResponseDTO> users() {
		return service.getusers();
	}
	
	@GetMapping(path="/user/{userName}", produces="application/json")
	public UserResponseDTO user(@PathVariable String userName) {
		return service.getUser(userName);
	}
	
	@PostMapping(path="/enterUser", consumes="application/json", produces="application/json")
	public UserResponseDTO enterUser(@RequestBody UserRequestDTO dto) {
		return service.insertUser(dto);
	}
	
	@PutMapping(path="/updateUserName", consumes="application/json")
	public UserResponseDTO updateUserName(@RequestBody UserRequestDTO dto) {
		return service.updateUserName(dto);
	}
	
	@PutMapping(path="/updateEmailID", consumes="application/json")
	public UserResponseDTO updateEmailID(@RequestBody UserRequestDTO dto) {
		return service.updateEmailID(dto);
	}
	
	@PutMapping(path="/updatePassword", consumes="application/json")
	public UserResponseDTO updatePassword(@RequestBody UserRequestDTO dto) {
		return service.updatePassword(dto);
	}
}
