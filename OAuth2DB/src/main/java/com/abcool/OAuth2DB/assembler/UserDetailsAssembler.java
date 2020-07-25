package com.abcool.OAuth2DB.assembler;

import org.springframework.security.core.userdetails.UserDetails;

import com.abcool.OAuth2DB.entity.AuthUserDetails;
import com.abcool.OAuth2DB.entity.User;

public class UserDetailsAssembler implements IUserDetailsAssembler{

	@Override
	public UserDetails toDomain(User user) {
		AuthUserDetails userDetails = new AuthUserDetails();
		userDetails.setAccountExpired(user.isAccountExpired());
		userDetails.setAccountLocked(user.isAccountLocked());
		userDetails.setCredentialsExpired(user.isCredentialsExpired());
		userDetails.setEmail(user.getEmail());
		userDetails.setEnabled(user.isEnabled());
		userDetails.setUsername(user.getUsername());
		userDetails.setRole_users(user.getRole_users());
		userDetails.setUser_id(user.getUser_id());
		return userDetails;
	}

	@Override
	public User fromDomain(UserDetails userdetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
