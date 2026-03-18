package com.nareshit.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nareshit.entity.Customer;

@FeignClient("CUSTOMER-SERVICE")
public interface customerFeignInterface {

	@GetMapping("/customers/{id}")
	public Optional<Customer> fetchCustomerById(@PathVariable Long id);

}
