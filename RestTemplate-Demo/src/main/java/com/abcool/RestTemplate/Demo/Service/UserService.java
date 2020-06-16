package com.abcool.RestTemplate.Demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abcool.RestTemplate.Demo.DTOs.RequestDTO;
import com.abcool.RestTemplate.Demo.DTOs.ResponseDTO;
import com.abcool.RestTemplate.Demo.entity.GitHubUser;

@Service
public class UserService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public ResponseDTO getDetails(RequestDTO dto) {
		ResponseDTO dt = new ResponseDTO();
		dt.setGituser(restTemplate.getForEntity(String.format("https://api.github.com/users/%s", dto.getUserName()), GitHubUser.class));
		
		return dt;
	}

}
