package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.ShippingAddress;

public class ShippingAddressDaoImpl implements ShippingAddressDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void saveOrUpdate(ShippingAddress shippingAddress) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(shippingAddress);
	}
	public ShippingAddress getShippingAddress(int id) {
		Session session=sessionFactory.getCurrentSession();
		ShippingAddress shippingAddress=(ShippingAddress)session.get(ShippingAddress.class, id); 
		return shippingAddress;
	}

}
