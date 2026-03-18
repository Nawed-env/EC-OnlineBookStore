package com.nareshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.entity.CartModule;
import com.nareshit.entity.Customer;
import com.nareshit.entity.bookModule;

public interface CartModuleRepo extends JpaRepository<CartModule, Long> {

	
	public CartModule findByCustomerAndBookmodules(Customer customer, bookModule booksModule);

}
