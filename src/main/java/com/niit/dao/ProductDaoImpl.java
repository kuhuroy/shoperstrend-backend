package com.niit.dao;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	public ProductDaoImpl() {
		System.out.println("product dao bean created...");
		
	}


	@Transactional
	public List<Product> getProductLists(){
		Session session=sessionFactory.getCurrentSession();
		String hqlQuery="from product";
		Query query=session.createQuery(hqlQuery);
		List<Product> products=query.list();
		return products;
	}
	
	
	public Product getProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product)session.get(Product.class, id);
		return product;
	}
	
	public void deleteProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product= (Product)session.get(Product.class, id);
		session.delete(product);
	}
	
	
	public void saveOrUpdateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
	}
	
	
	public List<Category> getAllCategories() {
		Session session=sessionFactory.getCurrentSession();
		//select * from category_s180396
		Query query=session.createQuery("from Category");
		List<Category> categories=query.list();
		return categories;
	}
}
