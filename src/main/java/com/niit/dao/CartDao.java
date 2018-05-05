package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao {
	void addToCart(Cart cart);
	List<Cart> getCartItems();
}
