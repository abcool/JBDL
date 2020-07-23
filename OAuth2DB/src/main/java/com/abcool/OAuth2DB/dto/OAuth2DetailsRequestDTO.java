package com.abcool.OAuth2DB.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuth2DetailsRequestDTO {

	private String client_id;
	
	private String client_secret;
	
	private String web_server_redirect_uri;
	
	private String scope;
	
	private Integer access_token_validity;
	
	private Integer refresh_token_validity;
	
	private String resource_ids;
	
	private String authorized_grant_types;
	
	private String authorities;
	
	private String additional_information;
	
}
