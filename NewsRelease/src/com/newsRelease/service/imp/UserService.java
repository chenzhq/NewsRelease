package com.newsRelease.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsRelease.dao.ICommentDao;
import com.newsRelease.dao.IUserDao;
import com.newsRelease.model.Comment;
import com.newsRelease.model.User;


@Service("userService")
@Transactional
public class UserService {
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;
	
	@Autowired
	@Qualifier("commentDao")
	private ICommentDao commentDao;

	public User findByUserName(String username) {
		return userDao.findByProperty("name", username).size() > 0 ? userDao.findByProperty("name", username).get(0) : null;
	}
	
	public void saveComment(Comment entity) {
		commentDao.save(entity);
	}
	public void saveUser(User u) {
		userDao.save(u);
	}

}
