package com.abcool.OAuth2DB.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * create table if not exists  user (
  id int(11) not null auto_increment,
  username varchar(100) not null,
  password varchar(1024) not null,
  email varchar(1024) not null,
  enabled tinyint(4) not null,
  accountNonExpired tinyint(4) not null,
  credentialsNonExpired tinyint(4) not null,
  accountNonLocked tinyint(4) not null,
  primary key (id),
  unique key username (username)
) engine=innodb ;
 * 
 *
 */

@Getter
@Setter
@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(nullable=false,length=11)
	private String user_id;
	
	@Column(nullable=false,length=100, unique=true)
	private String username;
	
	@Column(nullable=false,length=1024)
	private String password;
	
	@Column(nullable=false,length=1024)
	private String email;
	
	@Column(nullable=false,length=1)
	private char isEnabled;
	
	@Column(nullable=false,length=1)
	private char isAccountExpired;
	
	@Column(nullable=false,length=1)
	private char isCredentialsExpired;
	
	@Column(nullable=false,length=1)
	private char isAccountLocked;
	
	@OneToMany(mappedBy="user")
	private Set<Role_User> role_users;
}
