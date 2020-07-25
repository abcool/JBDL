package com.abcool.OAuth2DB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abcool.OAuth2DB.dto.OAuth2DetailsRequestDTO;
import com.abcool.OAuth2DB.dto.OAuth2DetailsResponseDTO;
import com.abcool.OAuth2DB.entity.OAuthClientDetails;
import com.abcool.OAuth2DB.repository.OAuth2DetailsRepository;

@Service
public class OAuth2DetailsServiceImpl implements IOAuth2DetailsService{
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Autowired 
	OAuth2DetailsRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public OAuth2DetailsResponseDTO createClientDetails(OAuth2DetailsRequestDTO requestDTO) {
		OAuth2DetailsResponseDTO response = new OAuth2DetailsResponseDTO();
		if(requestDTO.getClient_id()==null || requestDTO.getClient_secret()==null) {
			response.setMessage("Please enter correct details");
		}else {
		OAuthClientDetails domain = new OAuthClientDetails();
		domain.setClient_id(requestDTO.getClient_id());
		domain.setClient_secret(encoder.encode(requestDTO.getClient_secret()));
		domain.setWeb_server_redirect_uri(requestDTO.getWeb_server_redirect_uri());
		domain.setScope(requestDTO.getScope());
		domain.setAccess_token_validity(requestDTO.getAccess_token_validity());
		domain.setRefresh_token_validity(requestDTO.getRefresh_token_validity());
		domain.setResource_ids(requestDTO.getResource_ids());
		domain.setAuthorized_grant_types(requestDTO.getAuthorized_grant_types());
		domain.setAdditional_information(requestDTO.getAdditional_information());
		try {
			repo.save(domain);
		}catch(Exception e) {
			response.setMessage("Error occured while saving client details ");
			e.printStackTrace();
		}
		
		}
		return response;
	}
	
	
}
