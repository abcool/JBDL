package com.abcool.OAuth2DB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * create table if not exists  oauth_client_details (
  client_id varchar(255) not null,
  client_secret varchar(255) not null,
  web_server_redirect_uri varchar(2048) default null,
  scope varchar(255) default null,
  access_token_validity int(11) default null,
  refresh_token_validity int(11) default null,
  resource_ids varchar(1024) default null,
  authorized_grant_types varchar(1024) default null,
  authorities varchar(1024) default null,
  additional_information varchar(4096) default null,
  autoapprove varchar(255) default null,
  primary key (client_id)
) engine=innodb ;
 * 
 *
 */

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
