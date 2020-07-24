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

/**
 * 
 * create table if not exists  permission (
  id int(11) not null auto_increment,
  name varchar(512) default null,
  primary key (id),
  unique key name (name)
) engine=innodb ;
 *
 */

@Getter
@Setter
@Entity
@Table(name="permission")
public class Permission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, length=11)
	private Integer id;
	
	@Column(length=512, unique=true)
	private String name;
	
	/**
	 * mappedBy="myName", myName must be equal to object reference of parent 
	 * in the child table.
	 */
	@OneToMany(mappedBy="permission")
	private Set<Permission_Role> permission_roles;
}
