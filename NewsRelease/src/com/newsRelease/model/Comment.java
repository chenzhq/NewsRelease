package com.newsRelease.model;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "newsrelease")
public class Comment extends com.newsRelease.model.BaseModel implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private User user;
	private News news;
	private String commentContent;
	private Timestamp commentPubTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String id, User user, News news, String commentContent,
			Timestamp commentPubTime) {
		this.id = id;
		this.user = user;
		this.news = news;
		this.commentContent = commentContent;
		this.commentPubTime = commentPubTime;
	}


	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy="uuid")
	@Column(name = "comment_id", unique = true, nullable = false, length = 128)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "news_id", nullable = false)
	public News getNews() {
		return this.news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Column(name = "comment_content", nullable = false, length = 200)
	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Column(name = "comment_pub_time", nullable = false, length = 19)
	public Timestamp getCommentPubTime() {
		return this.commentPubTime;
	}

	public void setCommentPubTime(Timestamp commentPubTime) {
		this.commentPubTime = commentPubTime;
	}

}