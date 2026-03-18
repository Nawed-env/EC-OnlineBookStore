package com.nareshit.service;

import com.nareshit.entity.CartModule;

public interface CartModuleService {

	CartModule addToCart(Long custemerId, Long bookId, int quantity);
	
}
