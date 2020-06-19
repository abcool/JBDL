package com.abcool.Library.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abcool.Library.Management.System.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	public Users findByUserName(String userName);
	
	@Query("update users u set u.password=password where u.userID=id")
	public Users updatePassword(String password, int id);
	
	@Query("update users u set u.userName=userName where u.userID=id")
	public Users updateUsername(String userName, int id);
	
	@Query("update users u set u.emaidID=emailID where u.userID=id")
	public Users updateEmaiID(String emailID, int id);

}
