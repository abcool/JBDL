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
@Table(name="oauth_access_token")
public class OAuth_Access_Token {

	@Column(length=256)
	private String token_id;
	
	private byte[] token;
	
	@Id
	@Column(length=256)
	private String authentication_id;
	
	@Column(length=256)
	private String user_name;
	
	@Column(length=256)
	private String client_id;
	
	private byte[] authentication;
	
	@Column(length=256)
	private String refresh_token;
}
