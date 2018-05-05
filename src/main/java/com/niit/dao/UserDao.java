package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {
	void insertUpdateUserDetails(User user);
	User getUserDetail(String username);
	void deleteUserDetail(User user);
	List<User> getUsersDetails();
}
