package com.gk.productservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.gk.productservice.auditor.Auditable;

@Entity
public class Category extends Auditable<String>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String name;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
