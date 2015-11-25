package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.UserDetails;

public interface UserDetailsDao {

	UserDetails findById(int id);

	void saveUserDetails(UserDetails user);
	
	void deleteUserDetails(UserDetails user);
	
	List<UserDetails> findAllUserDetails();

}
