package com.abcool.SpringSecurity.SpringSecurityDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.abcool.SpringSecurity.SpringSecurityDemo.User;
import com.abcool.SpringSecurity.SpringSecurityDemo.DTOs.DemoRequestDTO;
import com.abcool.SpringSecurity.SpringSecurityDemo.Repository.DemoRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	DemoRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repo.findByUserName(username);
	}
	
	public String saveUser(DemoRequestDTO dto) {
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(10)));
		user.setActive(true);
		user.setRoles(dto.getRoles());
		if(repo.save(user) !=null){
			return "User saved successfully";
		}else {
		return "There was a problem saving user, please try again";
		}
	}
}
