package com.xcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xcenter.entity.XUser;
import com.xcenter.repository.XUserRepository;

@Service
public class XUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String mobile)
			throws UsernameNotFoundException {
		XUser user = repository.findByMobile(mobile);
		System.out.println("user -> " + mobile);
		if (user == null)
			System.out.println("User not available");
		return new XUserDetails(user);
	}

	@Autowired
	private XUserRepository repository;

}
