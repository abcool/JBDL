package com.abcool.Library.Management.System.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abcool.Library.Management.System.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	public Users findByUserName(String userName);
	
	@Transactional
	@Modifying
	@Query("update Users u set u.password=:password where u.userID=:id")
	public Integer updatePassword(String password, int id);
	
	@Transactional
	@Modifying
	@Query("update Users u set u.userName=:userName where u.userID=:id")
	public Integer updateUsername(String userName, int id);
	
	@Transactional
	@Modifying
	@Query("update Users u set u.emailID=:emailID where u.userID=:id")
	public Integer updateEmaiID(String emailID, int id);

}
