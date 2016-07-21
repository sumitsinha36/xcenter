package com.xcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xcenter.entity.Xuser;
import com.xcenter.repository.XUserRepository;

@Service
public class XUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String mobile)
			throws UsernameNotFoundException {
		Xuser user = repository.findByMobile(mobile);
		System.out.println("user -> " + mobile);
		if (user == null) {
			System.out.println("User not available");
			/*Xuser x = new Xuser();
			x.setEmail("vinnnnz@gmail.com");
			x.setFullName("vineet kumar");
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			pe.encode("hello");
			x.setHashPassword(pe.encode("hello"));
			x.setMobile("9910375511");
			x.setProfilePicture("my pro pic");
			List<Role> list = new ArrayList<Role>();
			list.add(Role.ADMIN);
			x.setRoles(list);
			repository.save(x);*/
		}
		return new XUserDetails(user);
	}

	@Autowired
	private XUserRepository repository;

}
