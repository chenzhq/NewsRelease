package com.newsRelease.dao.imp;



import org.springframework.stereotype.Repository;


import com.newsRelease.dao.IUserDao;
import com.newsRelease.model.User;

@Repository("userDao")
public class UserDAO extends BaseDao<User> implements IUserDao {
	
	
}