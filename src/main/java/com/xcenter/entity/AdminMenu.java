package com.xcenter.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AdminMenu implements Serializable{

	private static final long serialVersionUID = 8698888603739669696L;

	@Id
	private String id;
	
	private String name;
	
	private String template;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String template) {
		this.template = template;
	}

}
