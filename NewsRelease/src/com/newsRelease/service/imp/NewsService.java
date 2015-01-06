package com.newsRelease.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsRelease.dao.INewsDao;
import com.newsRelease.dao.IPhotoDao;
import com.newsRelease.model.News;
import com.newsRelease.model.Photo;

@Service("newsService")
@Transactional
public class NewsService {

	private final String[] TYPES = {"international","sports", "entertainment", "society", "politics"} ;
	@Autowired
	@Qualifier("newsDao")
	private INewsDao newsDao;
	
	@Autowired
	@Qualifier("photoDao")
	private IPhotoDao photoDao;


	public List<News> getAllNews() {
		return newsDao.findAll();
	}
	
	public List<News> getNewsByStyle(String style) {
		return newsDao.findByProperty("newsStyle", style);
	}
	
	public int[] getNewsNum() {
		int[] allCounts = new int[TYPES.length];
		for(int i = 0; i < TYPES.length; ++i) {
			allCounts[i] = newsDao.findByProperty("newsStyle", TYPES[i]).size() ;
		}
		return allCounts;
	}
		
	public void insertNews(News n) {
		newsDao.save(n);
	}
	
	public void insertPho(Photo p) {
		photoDao.save(p);
	}
	
	public Map<String, List<News>> getAllNewsByType() {
		Map<String, List<News>> map = new HashMap<String, List<News>>();
		for(int i = 0;i < TYPES.length; ++i) {
			map.put(TYPES[i], newsDao.findByProperty("newsStyle", TYPES[i])) ;
		}
		return map;
	}
}
