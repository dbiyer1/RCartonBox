package com.library.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.library.entity.UserArticleTransaction;

public interface TransactionService {

	ResponseEntity<String> borrowArticles(int id, List<String> articleTitles);

	ResponseEntity<String> returnArticles(int id, List<String> articleTitles);

	List<UserArticleTransaction> getTransactionsExpiredDateOfReturn();
}
