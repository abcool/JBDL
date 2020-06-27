package com.abcool.SpringSecurity.SpringSecurityDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.SpringSecurity.SpringSecurityDemo.User;

public interface DemoRepository extends JpaRepository<User, Integer>{

	public User findByUserName(String userName);
}
