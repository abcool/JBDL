package com.abcool.OAuth2DB.entity;

import java.sql.Timestamp;

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
