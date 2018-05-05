package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.niit.dao.AuthoritiesDao;
//import com.niit.dao.AuthoritiesDaoImpl;
import com.niit.dao.CartDao;
import com.niit.dao.CartDaoImpl;
import com.niit.dao.CartItemDao;
import com.niit.dao.CartItemDaoImpl;
import com.niit.dao.CategoryDao;
import com.niit.dao.CategoryDaoImpl;
import com.niit.dao.CustomerDao;
import com.niit.dao.CustomerDaoImpl;
//import com.niit.dao.OrderDao;
//import com.niit.dao.OrderDaoImpl;
import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.dao.ShippingAddressDao;
import com.niit.dao.ShippingAddressDaoImpl;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.model.Authorities;
import com.niit.model.BillingAddress;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Customer;
//import com.niit.model.Order;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.User;
import com.niit.services.CartItemService;
import com.niit.services.CartItemServiceImpl;
import com.niit.services.CustomerService;
import com.niit.services.CustomerServiceImpl;
import com.niit.services.ProductServices;
import com.niit.services.ProductServicesImpl;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBconfiguration {
	@Bean(name="getBasicData")
	public DataSource getDataSource() {
		BasicDataSource getBasicData=new BasicDataSource();
		getBasicData.setDriverClassName("org.h2.Driver");
		getBasicData.setUrl("jdbc:h2:tcp://localhost/~/kuhu1");
		getBasicData.setUsername("sa");
		getBasicData.setPassword("sa");
		return getBasicData;	
	}
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory sessionFactory() {
		
		LocalSessionFactoryBuilder local=new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		local.addProperties(hibernateProperties);
		Class classes[]=new Class[]{Product.class,Customer.class,Category.class,User.class,Authorities.class,Cart.class,CartItem.class,ShippingAddress.class,BillingAddress.class};
		return local.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Autowired
	@Bean(name="transationManager")
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}
	@Bean(name="productDAO")
	public ProductDao getProductDao() {
		System.out.println("---Product bean is created---");
		return new ProductDaoImpl();
	}
	/*@Bean(name="productService")
	public ProductServices getProductServices() {
		System.out.println("---Product srvice is created---");
		return new ProductServicesImpl();
	}*/
	@Bean(name="customerDao")
	public CustomerDao getCustomerDao() {
		System.out.println("---Customer bean is created---");
		return new CustomerDaoImpl();
	}
	/*@Bean
	public CustomerService getCutomerService() {
		System.out.println("---Customer service is created---");
		return new CustomerServiceImpl();
	}*/
	@Bean(name="cartItemDao")
	public CartItemDao getCartItemDao() {
		System.out.println("---CartItem bean is created---");
		return new CartItemDaoImpl();
	}
	/*@Bean
	public CartItemService getCartItemService() {
		System.out.println("---CartItem service is created---");
		return new CartItemServiceImpl();
	}*/
	@Bean
	public CartDao getCartDao() {
		System.out.println("---Cart bean is created---");
		return new CartDaoImpl();
	}
	@Bean
	public CategoryDao getCategoryDao() {
		System.out.println("---Category bean is created---");
		return new CategoryDaoImpl();
	}
	@Bean
	public ShippingAddressDao getShippingAddressDao() {
		System.out.println("---ShippingAddress bean is created---");
		return new ShippingAddressDaoImpl();
	}
	@Bean
	public UserDao getUserDao() {
		System.out.println("---User bean is created---");
		return new UserDaoImpl();
	}
	
	/*@Bean
	public OrderDao getOrderDao() {
		System.out.println("---Order bean is created---");
		return new OrderDaoImpl();
	}*/
}
