package com.newsRelease.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsRelease.dao.IUserDao;
import com.newsRelease.model.User;


@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	public User findByUserName(String username) {
		User u = new User();
		u.setName(username);		
		return userDao.findByProperty("name", username).get(0);
	}

}
