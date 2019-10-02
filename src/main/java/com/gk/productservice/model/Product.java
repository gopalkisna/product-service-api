package com.gk.productservice.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Category category;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDT;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDT;

	public Product() {
		super();
	}

	public Product(String id, String name, String description, LocalDateTime createdDT, Date updatedDT) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdDT = createdDT;
		this.updatedDT = updatedDT;
	}

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

	public LocalDateTime getCreatedDT() {
		return createdDT;
	}

	public void setCreatedDT(LocalDateTime createdDT) {
		this.createdDT = createdDT;
	}

	public Date getUpdatedDT() {
		return updatedDT;
	}

	public void setUpdatedDT(Date updatedDT) {
		this.updatedDT = updatedDT;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
