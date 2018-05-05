package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.model.CartItem;
import com.niit.model.User;

public class CartItemDaoImpl implements CartItemDao{
	@Autowired
	private SessionFactory sessisonFactory;
	public CartItemDaoImpl() {
		System.out.println("cartitem dao bean is created...");
	}
	public void saveOrUpdateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session =sessisonFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}

	public void removeCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		Session session=sessisonFactory.getCurrentSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		Session session=sessisonFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		return user;
	}
	
}
