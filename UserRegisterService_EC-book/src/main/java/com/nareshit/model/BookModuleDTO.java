package com.nareshit.model;

import jakarta.persistence.Column;

public class BookModuleDTO {


	@Column(name = "name")
	private String name;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name="price")
	private double price;

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

	public BookModuleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BookModuleDTO(String name, String title, String author) {
		super();
		this.name = name;
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookModuleDTO [name=" + name + ", title=" + title + ", author=" + author + "]";
	}





}