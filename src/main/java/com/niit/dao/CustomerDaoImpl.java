package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Authorities;
import com.niit.model.Cart;
import com.niit.model.Customer;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	private SessionFactory sessionFactory;
	public CustomerDaoImpl() {
		System.out.println("customer dao bean created...");
	}
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		customer.getUser().setEnabled(true);
		Authorities authorities= new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUser(customer.getUser());
		Cart cart=new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);
		
		session.save(customer);
	}

}
