package com.abcool.OAuth2DB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * create table if not exists oauth_code (
  code VARCHAR(256), authentication LONG VARBINARY
);
 * 
 *
 */

@Getter
@Setter
@Entity
@Table(name="oauth_code")
public class OAuth_Code {

	@Id
	private Integer Id;
	
	@Column(length=256)
	private String code;
	
	private byte[] authentication;
}
