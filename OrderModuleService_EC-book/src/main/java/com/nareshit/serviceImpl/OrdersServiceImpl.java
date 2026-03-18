package com.nareshit.serviceImpl;

import java.util.List;

import com.nareshit.model.OrderModuleDto;
import com.nareshit.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	@Override
	public String saveOrders(OrderModuleDto orderModuleDto) {

		// 1. check if the request body or titles are empty
		if(orderModuleDto==null || orderModuleDto.getTitle()==null || orderModuleDto.getTitle().isEmpty()) {
			return "No books selected. Please select at least one book to proceed.";

		}
		// 2. Extract customer ID and selected book titles
		Long custmerId = orderModuleDto.getCustmerId();
		List<String> selectedBooks = orderModuleDto.getTitle();
		return null;
	}

	

}
