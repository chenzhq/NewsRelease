package com.newsRelease.dao.imp;

import java.lang.reflect.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;


import com.newsRelease.dao.IBaseDao;


public class BaseDao<T> implements IBaseDao<T> {
	
	private static final Logger log = LoggerFactory.getLogger(BaseDao.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	private Class<T> entityClass;

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class<T>) params[0];
	}
	
	@Override
	public void save(Object entity) {
		log.debug("saving Model instance");
		try {
			getHibernateTemplate().save(entity);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	@Override
	public void delete(Object entity) {
		log.debug("deleting Model instance");
		try {
			getHibernateTemplate().delete(entity);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public T findById(java.lang.String id) {
		log.debug("getting Model instance with id: " + id);
		try {
			T instance = (T) getHibernateTemplate().get(
					entityClass, id);
			return (T)instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByExample(Object entity) {
		log.debug("finding Model instance by example");
		try {
			List<T> results = (List<T>) getHibernateTemplate()
					.findByExample(entity);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		log.debug("finding Model instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from " + entityClass.getSimpleName() + " as model where model."
					+ propertyName + "= ?";			
			return (List<T>)getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		log.debug("finding all Model instances");
		try {
			String queryString = "from " + entityClass.getSimpleName();
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(Object entity) {
		log.debug("merging Model instance");
		try {
			T result = (T) getHibernateTemplate().merge(entity);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Object entity) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(entity);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}*/

	/*public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}*/
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
   
}
