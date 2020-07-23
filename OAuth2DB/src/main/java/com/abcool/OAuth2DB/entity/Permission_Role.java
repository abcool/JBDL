package com.abcool.OAuth2DB.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * create table  if not exists permission_role (
  permission_id int(11) default null,
  role_id int(11) default null,
  key permission_id (permission_id),
  key role_id (role_id),
  constraint permission_role_ibfk_1 foreign key (permission_id) references permission (id),
  constraint permission_role_ibfk_2 foreign key (role_id) references role (id)
) engine=innodb ;
 *
 *
 */

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
