package com.newsRelease.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Photos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photos", catalog = "newsrelease")
public class Photo extends BaseModel implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String photoId;
	private News news;
	private String photo;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(News news, String photo) {
		this.news = news;
		this.photo = photo;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy="uuid")
	@Column(name = "photo_id", unique = true, nullable = false, length = 128)
	public String getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "news_id", nullable = false)
	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Column(name = "photo", nullable = false, length=100)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}