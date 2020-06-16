package com.abcool.RestTemplate.Demo.DTOs;

import org.springframework.http.ResponseEntity;

import com.abcool.RestTemplate.Demo.entity.GitHubUser;

public class ResponseDTO {
	ResponseEntity<GitHubUser> gituser;

	public ResponseEntity<GitHubUser> getGituser() {
		return gituser;
	}

	public void setGituser(ResponseEntity<GitHubUser> gituser) {
		this.gituser = gituser;
	}
}
