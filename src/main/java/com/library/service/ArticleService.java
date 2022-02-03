package com.library.service;

import java.util.List;

import com.library.entity.Article;

public interface ArticleService {

	List<Article> getArticles();

	void addArticle(Article article);

	boolean deleteArticle(int id);
}
