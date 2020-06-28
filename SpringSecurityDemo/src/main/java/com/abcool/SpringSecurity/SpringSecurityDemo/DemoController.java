package com.abcool.SpringSecurity.SpringSecurityDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.SpringSecurity.SpringSecurityDemo.DTOs.AuthenticationRequest;
import com.abcool.SpringSecurity.SpringSecurityDemo.DTOs.AuthenticationResponse;
import com.abcool.SpringSecurity.SpringSecurityDemo.DTOs.DemoRequestDTO;
import com.abcool.SpringSecurity.SpringSecurityDemo.service.UserService;
import com.abcool.SpringSecurity.SpringSecurityDemo.utils.JWTService;

@RestController
public class DemoController {
	
	@Autowired
	UserService service;
	
	@Autowired
	AuthenticationManager authenticatonManager;
	
	@Autowired
	JWTService jwtToken;

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
	
	@PostMapping("/authenticate")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{
		try {
			authenticatonManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
			
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails details = service.loadUserByUsername(request.getUsername());
		final String jwt = jwtToken.generateToken(details);
		return new AuthenticationResponse(jwt);
	}
}
