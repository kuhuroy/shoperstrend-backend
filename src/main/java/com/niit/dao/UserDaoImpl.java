package com.niit.dao;

import java.util.List;

import org.hibernate.Query;

//import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public void insertUpdateUserDetails(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		session.flush();
	}

	public User getUserDetail(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		return user;
	}
	@Transactional
	public void deleteUserDetail(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public List<User> getUsersDetails() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User");
		List<User> list=query.list();
		session.close();
		return list;
	}

}
