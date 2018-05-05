package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.Category;
import com.niit.model.Product;
@Service
public class ProductServicesImpl implements ProductServices{
	@Autowired(required=true)
	private ProductDao productDao;
	public ProductServicesImpl() {
		System.out.println("product services bean is created.");
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getProductLists();
	}
	
	
	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}
	
	
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}
	
	
	public void updateProduct(Product product) {
		productDao.saveOrUpdateProduct(product);
	}
	
	
	public void saveProduct(Product product) {
		productDao.saveOrUpdateProduct(product);
	}
	
	
	public List<Category> getAllCategories() {
		return productDao.getAllCategories();
	}
}
