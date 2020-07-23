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
 * create table if not exists role_user (
  role_id int(11) default null,
  user_id int(11) default null,
  key role_id (role_id),
  key user_id (user_id),
  constraint role_user_ibfk_1 foreign key (role_id) references role (id),
  constraint role_user_ibfk_2 foreign key (user_id) references user (id)
) engine=innodb ;
 * 
 *
 */

@Getter
@Setter
@Entity
@Table(name="role_user")
public class Role_User {

	@Id
	private Integer id;
	
	@Column(length=11)
	private Integer role_id;
	
	@Column(length=11)
	private Integer user_id;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="id", nullable=false)
	private User user;
}
