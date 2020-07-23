package com.abcool.OAuth2DB.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * create table if not exists oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);
 * 
 *
 */
@Getter
@Setter
@Entity
@Table(name="oauth_approvals")
public class OAuth_Approvals {

	@Id
	private Integer id;
	
	@Column(length=256)
	private String userId;
	
	@Column(length=256)
	private String clientId;
	
	@Column(length=256)
	private String scope;
	
	@Column(length=10)
	private String status;
	
	private Timestamp expiresAt;
	
	private Timestamp lastModifiedAt;
}
