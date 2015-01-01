package com.newsRelease.dao;

import java.util.List;


public interface IBaseDao<T> {
	
	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(java.lang.String id);
	
	public List<T> findByExample(T entity);
	
	public List<T> findByProperty(String propertyName, Object value);
	
	public List<T> findAll();
	
	public T merge(T entity);
	
	public void attachDirty(T entity);
}
