package com.nareshit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class userRequestDto {


	private String firstName;

	private String lastName;

	@NotBlank(message = "Email cannot blank")
	@Schema(description = "email",example = "Enter the email")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "password cannot blank")
	@Schema(description = "password",example = "Enter the password")
	@Column(name = "password")
	private String password;

	private Long contactId;


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getContactId() {
		return contactId;
	}


	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}


}