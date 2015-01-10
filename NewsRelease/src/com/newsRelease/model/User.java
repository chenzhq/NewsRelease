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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "newsrelease")
public class User extends com.newsRelease.model.BaseModel implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private String name;
	private String pwd;
	private Boolean authority;
	private Boolean sex;
	private Timestamp regTime;
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String pwd, Boolean authority, Timestamp regTime) {
		this.name = name;
		this.pwd = pwd;
		this.authority = authority;
		this.regTime = regTime;
	}

	/** full constructor */
	public User(String name, String pwd, Boolean authority, Boolean sex,
			Timestamp regTime, Set<Comment> comments) {
		this.name = name;
		this.pwd = pwd;
		this.authority = authority;
		this.sex = sex;
		this.regTime = regTime;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy="uuid")
	@Column(name = "user_id", unique = true, nullable = false, length = 128)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pwd", nullable = false, length = 16)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "authority", nullable = false)
	public Boolean getAuthority() {
		return this.authority;
	}

	public void setAuthority(Boolean authority) {
		this.authority = authority;
	}

	@Column(name = "sex")
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "reg_time", nullable = false, length = 19)
	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}