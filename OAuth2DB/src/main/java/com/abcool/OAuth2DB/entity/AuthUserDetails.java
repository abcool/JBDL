package com.abcool.OAuth2DB.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetails extends User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4320320413736660589L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		getRole_users().forEach(role ->{
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getUser().getUsername()));
			role.getRole().getPermission_roles().forEach(permission -> {
				grantedAuthorities.add(new SimpleGrantedAuthority(permission.getPermission().getName()));
			});
		});
		return grantedAuthorities;
	}
	@Override
	public String getPassword() {
		
		return super.getPassword();
	}
	
	@Override
	public String getUsername() {
		
		return super.getUsername();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		return super.isAccountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return super.isAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return super.isCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		
		return super.isEnabled();
	}

}
