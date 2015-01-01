package com.newsRelease.dao.imp;

import org.springframework.stereotype.Repository;

import com.newsRelease.dao.IBaseDao;
import com.newsRelease.model.News;

@Repository
public class NewsDao extends BaseDao<News> implements IBaseDao<News> {

}
