package com.abcool.OAuth2DB.assembler;

import org.springframework.security.core.userdetails.UserDetails;

import com.abcool.OAuth2DB.entity.User;

public interface IUserDetailsAssembler {

	/**
	 * @apiNote Maps User object to UserDetailsObject
	 * @param user
	 * @return
	 */
	public UserDetails toDomain(User user);
	
	/**
	 * @apiNote Maps UserDetails object to User Object
	 * @param userdetails
	 * @return
	 */
	public User fromDomain(UserDetails userdetails);
}
