package com.nareshit.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.entity.CartModule;
import com.nareshit.model.ResponseMessage;
import com.nareshit.service.CartModuleService;
import com.nareshit.utility.Constants;

@RestController
public class CartModuleController {

	@Autowired
	private CartModuleService cartModuleService;
	
	
	@PostMapping("/addCart")
	public ResponseEntity<ResponseMessage> createCustmer(@RequestParam Long customerId,
														 @RequestParam Long bookId,
														 @RequestParam int quentity){
		try {
			CartModule toCart = cartModuleService.addToCart(customerId, bookId, quentity);
			if(toCart!=null) {
			       return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "Added cart successfully", toCart));
			       
			}else {
				 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "Added cart Failed", toCart));

			}
		}catch (Exception e) {
			 return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR, Constants.FAILED, "Internal server error"));
		}
	}
}
