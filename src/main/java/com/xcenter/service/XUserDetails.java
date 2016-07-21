package com.xcenter.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.xcenter.entity.Xuser;
import com.xcenter.role.Role;

public class XUserDetails implements UserDetails {

	private static final long serialVersionUID = -4458281580086062029L;
	Xuser user;

	public XUserDetails(Xuser user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if (user.getRoles() == null) {
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority(
					Role.ADMIN.name());
			authList.add(auth);
		} else {
			for (Role role : user.getRoles()) {
				SimpleGrantedAuthority auth = new SimpleGrantedAuthority(
						role.name());
				authList.add(auth);
			}
		}

		return authList;
	}

	@Override
	public String getPassword() {
		if (user != null) {
			return user.getHashPassword();
		} else {
			return null;
		}
	}

	@Override
	public String getUsername() {

		return user.getMobile();
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
		return true;
	}

}
