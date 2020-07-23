package com.abcool.OAuth2DB.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="oauth_refresh_token")
public class OAuth_Refresh_Token {

	@Id
	private Integer id;
	
	@Column(length=256)
	private String token_id;
	
	private byte[] token;
	
	private byte[] authentication;
	
}
