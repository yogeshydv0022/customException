package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customException.GlobalExceptionHandler;
import com.model.CartItem;
import com.serviceImpl.CartItemServiceImpl;

@RestController
@RequestMapping("/cartitem/")
public class CartItemController {
	
	@Autowired
	private CartItemServiceImpl cartitemService;
	
	 // addCartItem
		@PostMapping
		public ResponseEntity<?> addCartItem(@RequestBody CartItem citem) {
			ResponseEntity<?> resp = null;
			try {
				CartItem item = cartitemService.addItem(citem);
				resp = new ResponseEntity<CartItem>(item, HttpStatus.CREATED);
			} catch (RuntimeException ex) {
				resp = new ResponseEntity<String>("unable to add cartItem "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return resp;
		}
	
	@GetMapping("/{id}")
	public CartItem getById(@PathVariable("id")Long id){
		return cartitemService.getById(id).orElseThrow(()-> 
		new GlobalExceptionHandler("cartItem not present with this id : "+id));
	}
	


}
