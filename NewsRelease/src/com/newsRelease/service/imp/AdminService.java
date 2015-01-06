package com.newsRelease.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.newsRelease.dao.IManagerDao;
import com.newsRelease.dao.IUserDao;
import com.newsRelease.model.Manager;


@Service("adminService")
public class AdminService {
	
	@Autowired
	@Qualifier("managerDao")
	private IManagerDao managerDao;
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	public Manager findByUserName(String name) {
//		Manager u = new Manager();
//		u.setName(username);		
		return managerDao.findByProperty("name", name).size() > 0?managerDao.findByProperty("name", name).get(0):null;
	}

	public int userCount() {
		return userDao.findAll().size();
		
	}
}
