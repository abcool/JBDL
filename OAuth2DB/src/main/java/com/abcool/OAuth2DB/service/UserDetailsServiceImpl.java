package com.abcool.OAuth2DB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abcool.OAuth2DB.assembler.UserDetailsAssembler;
import com.abcool.OAuth2DB.entity.User;
import com.abcool.OAuth2DB.repository.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements IUserDetailsService{

	@Autowired
	UserDetailsRepository repo;
	
	@Autowired
	UserDetailsAssembler userDetailsAssembler;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =  repo.findByUsername(username);
		if(user==null){
			throw new UsernameNotFoundException("Username or password entered is wrong");
		}
		
		new AccountStatusUserDetailsChecker().check(userDetailsAssembler.toDomain(user));
		
		return userDetailsAssembler.toDomain(user);
	}

}
