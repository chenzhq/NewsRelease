package com.newsRelease.dao.imp;

import org.springframework.stereotype.Repository;

import com.newsRelease.dao.IManagerDao;
import com.newsRelease.model.Manager;

@Repository("managerDao")
public class ManagerDao extends BaseDao<Manager> implements IManagerDao {

}
