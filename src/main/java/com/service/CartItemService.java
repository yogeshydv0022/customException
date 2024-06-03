package com.service;

import java.util.List;
import java.util.Optional;

import com.model.CartItem;

public interface CartItemService {
	
	public CartItem addItem(CartItem cTtem);
	
	public Optional<CartItem> updateItem(Long id,CartItem cTtem);
	
	public List<CartItem> getAllItems();
	
	public Optional<CartItem> getById(Long id);
	
	public String deleteItem(long id);

}
