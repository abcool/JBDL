package com.abcool.SpringSecurity.SpringSecurityDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abcool.SpringSecurity.SpringSecurityDemo.Repository.DemoRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	DemoRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByUserName(username);
	}
}
