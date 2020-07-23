package com.abcool.OAuth2DB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="oauth_client_details")
public class OAuthClientDetails {

	@Id
	@Column(nullable=false, length=255)
	private String client_id;
	
	@Column(nullable=false, length=255)
	private String client_secret;
	
	@Column(length=2048)
	private String web_server_redirect_uri;
	
	@Column(length=255)
	private String scope;
	
	@Column(length=11)
	private Integer access_token_validity;
	
	@Column(length=11)
	private Integer refresh_token_validity;
	
	@Column(length=1024)
	private String resource_ids;
	
	@Column(length=1024)
	private String authorized_grant_types;
	
	@Column(length=1024)
	private String authorities;
	
	@Column(length=4096)
	private String additional_information;
	
	@Column(length=255)
	private String autoapprove;
}
