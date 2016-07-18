package com.xcenter.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.xcenter.role.Role;


public class XUser {

	@Id
	private String mobile;
	
	private String fullName;
	
	private String profilePicture;
	
	private List<Role> roles;
	
	private String email;
	
	private String hashPassword;

	public XUser() {}
	
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the hashPassword
	 */
	public String getHashPassword() {
		return hashPassword;
	}

	/**
	 * @param hashPassword the hashPassword to set
	 */
	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "XUser [mobile=" + mobile + ", fullName=" + fullName
				+ ", profilePicture=" + profilePicture + ", roles=" + roles
				+ ", email=" + email + ", hashPassword=" + hashPassword + "]";
	}
}
