package com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.CartItem;
import com.repository.CartItemRepository;
import com.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	CartItemRepository cartItemRepository;

	@Override
	public CartItem addItem(CartItem citem) {
		return cartItemRepository.save(citem);
	}

	@Override
	public Optional<CartItem> updateItem(Long id, CartItem citem) {
		return null;
	}

	@Override
	public List<CartItem> getAllItems() {
		return cartItemRepository.findAll();
	}

	@Override
	public Optional<CartItem> getById(Long id) {
		return cartItemRepository.findById(id);
	}

	@Override
	public String deleteItem(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
