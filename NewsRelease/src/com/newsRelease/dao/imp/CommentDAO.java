package com.newsRelease.dao.imp;

import org.springframework.stereotype.Repository;

import com.newsRelease.dao.ICommentDao;
import com.newsRelease.model.Comment;

@Repository("commentDao")
public class CommentDAO extends BaseDao<Comment> implements ICommentDao{
	
	
}