package com.niit.dao;

import com.niit.model.ShippingAddress;

public interface ShippingAddressDao {
	void saveOrUpdate(ShippingAddress shippingAddress);
	ShippingAddress getShippingAddress(int id);
}
