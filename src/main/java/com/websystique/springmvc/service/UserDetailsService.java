package com.websystique.springmvc.service;

import java.util.List;


import com.websystique.springmvc.model.UserDetails;

public interface UserDetailsService {

	
	UserDetails findById(int id);
	
	void saveUserDetails(UserDetails user);
	
	void updateUserDetails(UserDetails user);
	
	void deleteUserDetails(UserDetails user);

	List<UserDetails> findAllUserDetails(); 
	
}
