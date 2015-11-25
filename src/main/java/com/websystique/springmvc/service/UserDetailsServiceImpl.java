package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.UserDetailsDao;
import com.websystique.springmvc.model.UserDetails;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDao dao;

	public UserDetails findById(int id) {
		return dao.findById(id);
	}

	public void saveUserDetails(UserDetails user) {
		dao.saveUserDetails(user);
		
	}

	public void updateUserDetails(UserDetails user) {
		UserDetails entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setBirthDate(user.getBirthDate());
		}
	}

	public void deleteUserDetails(UserDetails user) {
		dao.deleteUserDetails(user);
		
	}

	public List<UserDetails> findAllUserDetails() {
		return dao.findAllUserDetails();
	}
	
}
