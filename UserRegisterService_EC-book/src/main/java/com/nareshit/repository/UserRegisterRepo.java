package com.nareshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.entity.UserRegister;

public interface UserRegisterRepo extends JpaRepository<UserRegister, Long> {

	 public UserRegister findByEmail(String email);
}
