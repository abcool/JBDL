package com.abcool.Library.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.Library.Management.System.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	public Users findByUserName(String userName);
}
