package com.niit.services;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface ProductServices {
	List<Product> getAllProducts();
	Product getProduct(int id);
	void updateProduct(Product product);
	void deleteProduct(int id);
	void saveProduct(Product product);
	List<Category> getAllCategories();
}
