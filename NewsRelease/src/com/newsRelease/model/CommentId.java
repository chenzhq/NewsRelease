package com.newsRelease.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CommentId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CommentId extends com.newsRelease.model.BaseModel implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String newsId;

	// Constructors

	/** default constructor */
	public CommentId() {
	}

	/** full constructor */
	public CommentId(String userId, String newsId) {
		this.userId = userId;
		this.newsId = newsId;
	}

	// Property accessors

	@Column(name = "user_id", nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "news_id", nullable = false, length = 20)
	public String getNewsId() {
		return this.newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentId))
			return false;
		CommentId castOther = (CommentId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getNewsId() == castOther.getNewsId()) || (this
						.getNewsId() != null && castOther.getNewsId() != null && this
						.getNewsId().equals(castOther.getNewsId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getNewsId() == null ? 0 : this.getNewsId().hashCode());
		return result;
	}

}