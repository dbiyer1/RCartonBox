package com.library.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.Hidden;

@Table
@Entity
public class UserArticleTransaction {

	/**
	 * Sequence Generator added to have auto-incremented id set for every new
	 * transaction
	 */
	@Id
	@SequenceGenerator(name = "transactionSeq", sequenceName = "transactionSeq", initialValue = 100)
	@GeneratedValue(generator = "transactionSeq")
	@Hidden
	private Integer id;

	/**
	 * Established relationship with user since the same user can be involved in
	 * multiple transactions
	 */
	@ManyToOne
	private User user;

	/**
	 * Established relationship with article since the same article can be involved
	 * in multiple transactions
	 */
	@ManyToOne
	private Article article;

	@Column
	private LocalDateTime borrowedOn;

	@Column
	private LocalDateTime returnedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public LocalDateTime getBorrowedOn() {
		return borrowedOn;
	}

	public void setBorrowedOn(LocalDateTime borrowedOn) {
		this.borrowedOn = borrowedOn;
	}

	public LocalDateTime getReturnedOn() {
		return returnedOn;
	}

	public void setReturnedOn(LocalDateTime returnedOn) {
		this.returnedOn = returnedOn;
	}

}
