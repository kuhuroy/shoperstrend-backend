package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.BillingAddress;
import com.niit.model.Customer;

public class BillingAddressDaoImpl implements BillingAddressDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void saveOrUpdate(BillingAddress billingAddress) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(billingAddress);
	}
	public BillingAddress getBillingAddress(int id) {
		Session session=sessionFactory.getCurrentSession();
		BillingAddress billingAddress=(BillingAddress)session.get(BillingAddress.class, id);
		return billingAddress;
	}

	
}
