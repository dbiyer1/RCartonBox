package com.library.dto;

import java.time.LocalDateTime;

import com.library.entity.Article;
import com.library.entity.User;

public class UserArticleTransactionDto {

	private User user;

	private Article article;

	private LocalDateTime borrowedOn;

	private LocalDateTime returnedOn;

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
