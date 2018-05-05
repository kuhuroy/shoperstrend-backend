package com.niit.dao;

import com.niit.model.BillingAddress;
import com.niit.model.Customer;

public interface BillingAddressDao {
	void saveOrUpdate(BillingAddress billingAddress);
	BillingAddress getBillingAddress(int id);
}
