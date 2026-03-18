package com.nareshit.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.entity.CartModule;
import com.nareshit.entity.Customer;
import com.nareshit.entity.bookModule;
import com.nareshit.exception.BookIdNotFoundException;
import com.nareshit.exception.CustmerIDNotFoundException;
import com.nareshit.repository.CartModuleRepo;
import com.nareshit.service.CartModuleService;
import com.nareshit.service.bookFeignInterface;
import com.nareshit.service.customerFeignInterface;

@Service
public class CartModuleServiceImpl implements CartModuleService {

	@Autowired
	private CartModuleRepo cartModuleRepo;

	@Autowired
	private bookFeignInterface bookfeign;

	@Autowired
	private customerFeignInterface customerfeign;

	@Override // which customer? which book? how many copy
	public CartModule addToCart(Long custemerId, Long bookId, int quantity) {

		// Step 1: Check if customer exists in DB using ID
		// If not found, throw custom exception "Customer Id Not Found"
		System.err.println("id touch");
		Customer customer = customerfeign.fetchCustomerById(custemerId)
				.orElseThrow(() -> new CustmerIDNotFoundException("Customer does not exist"));

		// Step 2: Check if book exists in DB using ID
		// If not found, throw custom exception "Book Id not Found"
		bookModule booksModule = bookfeign.FetchBookById(bookId)
				.orElseThrow(() -> new BookIdNotFoundException("Book does not exist"));

		// Step 3: Check whether this customer already added this book in their cart
		// It helps to avoid duplicate entries for the same book
		CartModule cartItem = cartModuleRepo.findByCustomerAndBookmodules(customer, booksModule);

		// Step 4: If cartItem already exists, update quantity

		if (cartItem != null) {
			// Create new CartModule object with quantity, book, and customer
			cartItem.setQuantity(quantity + cartItem.getQuantity());
		} else {
			// Create new CartModule object with quantity, book, and customer
			cartItem = new CartModule(quantity, booksModule, customer);
//			cartModuleRepo.save(cartItem);

		}

		// Step 6: Calculate total price for that book (quantity × book price)
		cartItem.setTotalPrice(booksModule.getPrice() * cartItem.getQuantity());

		// Step 7: Save updated/created cart record to DB
		// This ensures cart data is persistent in database

		return cartModuleRepo.save(cartItem);

	}

}
