package com.newsRelease.dao.imp;

import org.springframework.stereotype.Repository;

import com.newsRelease.dao.IPhotoDao;
import com.newsRelease.model.Photo;

@Repository("photoDao")
public class PhotoDao extends BaseDao<Photo> implements IPhotoDao {

}
