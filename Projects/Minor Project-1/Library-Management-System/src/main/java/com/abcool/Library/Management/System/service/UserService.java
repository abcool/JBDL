package com.abcool.Library.Management.System.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcool.Library.Management.System.DTOs.UserRequestDTO;
import com.abcool.Library.Management.System.DTOs.UserResponseDTO;
import com.abcool.Library.Management.System.entity.Users;
import com.abcool.Library.Management.System.repository.UsersRepository;
import com.abcool.Library.Management.System.utilities.AESEncryption;
import com.abcool.Library.Management.System.validations.UserValidations;

@Service
public class UserService {

	@Autowired
	UsersRepository repo;
	
	public List<UserResponseDTO> getusers(){
		List<UserResponseDTO> dtos = new ArrayList<UserResponseDTO>();
		List<Users> users = repo.findAll();
		for(Users u : users) {
			UserResponseDTO dt = new UserResponseDTO();
			dt.setUserID(u.getUserID());
			dt.setUserName(u.getUserName());
			dt.setEmailID(u.getEmailID());
			dt.setPassword(AESEncryption.decrypt(u.getPassword()));
			dtos.add(dt);
		}
		return dtos;
	}
	
	public UserResponseDTO getUser(String userName) {
		Users user = repo.findByUserName(userName);
		UserResponseDTO response = new UserResponseDTO();
		response.setUserID(user.getUserID());
		response.setUserName(user.getUserName());
		response.setEmailID(user.getEmailID());
		response.setPassword(AESEncryption.decrypt(user.getPassword()));
		response.setMsg(user.getUserName() + "Found");
		return response;
	}
	
	public UserResponseDTO insertUser(UserRequestDTO dto) {
		UserResponseDTO response = new UserResponseDTO();
		String usernameValidation = UserValidations.checkUsername(dto.getUserName());
		String emailValidation = UserValidations.checkEmail(dto.getEmailID());
		String passwordValidation = UserValidations.checkPassword(dto.getPassword());
		if(usernameValidation.equalsIgnoreCase("true")==true && 
				emailValidation.equalsIgnoreCase("true")==true &&
				passwordValidation.equalsIgnoreCase("true")==true) {
		Users user = new Users(dto.getUserName(),AESEncryption.encrypt(dto.getPassword()),
				dto.getEmailID());
		repo.save(user);
		response.setEmailID(user.getEmailID());
		response.setUserName(user.getUserName());
		response.setPassword(user.getPassword());
		response.setMsg("User added successfully");
		return response;
		}else if(usernameValidation.equalsIgnoreCase("true")==false){			
			response.setMsg(usernameValidation);
			return response;
		}else if(emailValidation.equalsIgnoreCase("true")==false) {
			response.setMsg(emailValidation);
			return response;
		}else if(passwordValidation.equalsIgnoreCase("true")==false){
			response.setMsg(passwordValidation);
			return response;
		}else {
			response.setMsg("System cannot process the request right now, please try again");
			return response;
		}
	}
	
	public UserResponseDTO updateUserName(UserRequestDTO dto) {
		UserResponseDTO response = new UserResponseDTO();
		String userName = dto.getUserName();
		int id = dto.getUserID();
		Integer u = repo.updateUsername(userName, id);
		if(u!=null) {
		response.setMsg("Users Name successfully Updated");
		return response;
		}else {
			response.setMsg("There was some problem updating username, please try again");
			return response;
		}
	}
	
	public UserResponseDTO updateEmailID(UserRequestDTO dto) {
		UserResponseDTO response = new UserResponseDTO();
		String emailID = dto.getEmailID();
		int id = dto.getUserID();
		Integer u = repo.updateEmaiID(emailID, id);
		if(u!=null) {
		response.setMsg("Email ID successfully Updated");
		return response;
		}else {
			response.setMsg("There was some problem updating email ID, please try again");
			return response;
		}
	}
	
	public UserResponseDTO updatePassword(UserRequestDTO dto) {
		UserResponseDTO response = new UserResponseDTO();
		String password = AESEncryption.encrypt(dto.getPassword());
		int id = dto.getUserID();
		Integer u = repo.updatePassword(password, id);
		if(u!=null) {
		response.setMsg("Password successfully Updated");
		return response;
		}else {
			response.setMsg("There was some problem updating password, please try again");
			return response;
		}
	}
}
