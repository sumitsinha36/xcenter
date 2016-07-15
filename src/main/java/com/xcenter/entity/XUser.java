package com.xcenter.entity;

import org.springframework.data.annotation.Id;

import com.xcenter.role.Role;


public class XUser {

	@Id
	private String mobile;
	
	private String fullName;
	
	private String profilePicture;
	
	private Role role;
	
	private String email;
	
	private String hashPassword;

	public XUser() {}
	
	@Override
	public String toString() {
		return "XUser [mobile=" + mobile + ", fullName=" + fullName
				+ ", profilePicture=" + profilePicture + ", role=" + role
				+ ", email=" + email + ", hashPassword=" + hashPassword + "]";
	}
}
