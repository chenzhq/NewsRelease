package com.newsRelease.dao.imp;

import org.springframework.stereotype.Repository;


import com.newsRelease.dao.INewsDao;
import com.newsRelease.model.News;

@Repository("newsDao")
public class NewsDao extends BaseDao<News> implements INewsDao {

}
