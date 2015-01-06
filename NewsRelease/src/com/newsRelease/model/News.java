package com.newsRelease.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news", catalog = "newsrelease")
public class News extends BaseModel implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String newsId;
	private Manager manager;
	private String newsTitle;
	private String newsContent;
	private String newsStyle;
	private Timestamp newsPubTime;
	private Set<Photo> photoses = new HashSet<Photo>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(Manager manager, String newsTitle, String newsContent,
			String newsStyle, Timestamp newsPubTime) {
		this.manager = manager;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsStyle = newsStyle;
		this.newsPubTime = newsPubTime;
	}

	/** full constructor */
	public News(Manager manager, String newsTitle, String newsContent,
			String newsStyle, Timestamp newsPubTime, Set<Photo> photoses,
			Set<Comment> comments) {
		this.manager = manager;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsStyle = newsStyle;
		this.newsPubTime = newsPubTime;
		this.photoses = photoses;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy="uuid")
	@Column(name = "news_id", unique = true, nullable = false, length = 128)
	public String getNewsId() {
		return this.newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", nullable = false)
	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Column(name = "news_title", nullable = false, length = 30)
	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	@Column(name = "news_content", nullable = false)
	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	@Column(name = "news_style", nullable = false, length = 20)
	public String getNewsStyle() {
		return this.newsStyle;
	}

	public void setNewsStyle(String newsStyle) {
		this.newsStyle = newsStyle;
	}

	@Column(name = "news_pub_time", nullable = false, length = 19)
	public Timestamp getNewsPubTime() {
		return this.newsPubTime;
	}

	public void setNewsPubTime(Timestamp newsPubTime) {
		this.newsPubTime = newsPubTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "news")
	public Set<Photo> getPhotoses() {
		return this.photoses;
	}

	public void setPhotoses(Set<Photo> photoses) {
		this.photoses = photoses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "news")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}