package com.niit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartItemDao;
import com.niit.model.CartItem;
import com.niit.model.User;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	private CartItemDao cartItemDao;
	
	public CartItemServiceImpl() {
		System.out.println("cart item service bean is created...");
	}
	public void saveOrUpdateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.saveOrUpdateCartItem(cartItem);
	}

	public void removeCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		cartItemDao.removeCartItem(cartItemId);
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		return cartItemDao.getUser(email);
	}

}
