package com.abcool.OAuth2DB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * create table if not exists oauth_access_token (
  token_id VARCHAR(256),
  token LONG VARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(256)
);
 * 
 *
 */

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
