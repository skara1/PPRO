package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.UserDetails;

@Repository("userDetailsDao")
public class UserDetailsDaoImpl extends AbstractDao<Integer, UserDetails> implements UserDetailsDao{

	public UserDetails findById(int id) {
		return getByKey(id);
	}

	public void saveUserDetails(UserDetails user) {
		persist(user);	
	}

	public void deleteUserDetails(UserDetails user) {
		delete(user);	
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> findAllUserDetails() {
		Criteria criteria = createEntityCriteria();
		return (List<UserDetails>) criteria.list();
	}

}
