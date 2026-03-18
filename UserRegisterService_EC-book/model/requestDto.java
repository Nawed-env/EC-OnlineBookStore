package com.nareshit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class requestDto {



	private String firstName;
	private String lastName;




	public requestDto(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}




	public requestDto() {

		// TODO Auto-generated constructor stub
	}




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










}