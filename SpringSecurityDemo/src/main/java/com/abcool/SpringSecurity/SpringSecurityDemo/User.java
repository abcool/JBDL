package com.abcool.SpringSecurity.SpringSecurityDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
	
	private String userName;
	
	private String password;
	
	private boolean isActive;
	
	private String roles;

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	
	public User() {
	}

	public User(Integer userID, String userName, String password, boolean isActive, String roles) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.isActive = isActive;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] authArray = this.roles.split("#");
		System.out.println(authArray);
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(String s:authArray) {
			GrantedAuthority obj = new SimpleGrantedAuthority(s);
			authorities.add(obj);
		}
		return authorities;
	}

	@Override
		public String getPassword() {
			return this.password;
		}
	@Override
	public String getUsername() {
		return this.userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.isActive;
	}

	public Integer getUserID() {
		return userID;
	}

	public boolean isActive() {
		return isActive;
	}

	public String getRoles() {
		return roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
