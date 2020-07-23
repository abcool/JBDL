package com.abcool.OAuth2DB.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="permission_role")
public class Permission_Role {

	@Id
	private Integer id;
	
	@Column(length=11)
	private Integer permission_id;
	
	@Column(length=11)
	private Integer role_id;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private Permission permission;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private Role role;
}
