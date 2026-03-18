package com.nareshit.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nareshit.entity.bookModule;

@FeignClient(name = "BOOKS-SERVICE")
public interface bookFeignInterface {

	@GetMapping("/books/{id}")
	public Optional<bookModule> FetchBookById(@PathVariable Long id);
}
