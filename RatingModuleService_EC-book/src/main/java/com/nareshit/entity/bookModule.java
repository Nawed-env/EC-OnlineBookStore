package com.nareshit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Books_")
@Entity
public class bookModule {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;
	
	@Column(name="price")
	private double price;

	@CreationTimestamp
	@Column(name = "createdDate" ,updatable = false)
	public LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "updatedDate")
	public LocalDateTime updatedDate;

	

	

	@Override
	public String toString() {
		return "bookModule [id=" + id + ", name=" + name + ", title=" + title + ", author=" + author + ", price="
				+ price + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}



	public bookModule(Long id, String name, String title, String author, double price, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.author = author;
		this.price = price;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}



	public bookModule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	


}
