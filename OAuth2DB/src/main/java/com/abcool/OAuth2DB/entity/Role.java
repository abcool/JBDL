package com.abcool.OAuth2DB.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, length=11)
	private Integer id;
	
	@Column(length=255, unique=true)
	private String name;
	
	@OneToMany(mappedBy="role")
	private Set<Permission_Role> permission_roles;
	
	@OneToMany(mappedBy="role")
	private Set<Role_User> role_Users;
}
