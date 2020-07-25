package com.abcool.OAuth2DB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.OAuth2DB.entity.User;

public interface UserDetailsRepository extends JpaRepository<User, String>{

	public User findByUsername(String name);
	
}
