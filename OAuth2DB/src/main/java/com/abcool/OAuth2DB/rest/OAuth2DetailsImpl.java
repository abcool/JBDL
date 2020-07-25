package com.abcool.OAuth2DB.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.OAuth2DB.dto.OAuth2DetailsRequestDTO;
import com.abcool.OAuth2DB.dto.OAuth2DetailsResponseDTO;
import com.abcool.OAuth2DB.service.OAuth2DetailsServiceImpl;

@RestController
@RequestMapping("/oauthdetails")
public class OAuth2DetailsImpl implements IOAuth2Details{

	@Autowired
	OAuth2DetailsServiceImpl service;
	
	@PostMapping(path="/clientdetails", consumes="application/json")
	public OAuth2DetailsResponseDTO createClientDetails(@RequestBody OAuth2DetailsRequestDTO requestDTO) {
		return service.createClientDetails(requestDTO);
	}
}
