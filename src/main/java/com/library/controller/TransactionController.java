package com.library.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.UserArticleTransactionDto;
import com.library.entity.UserArticleTransaction;
import com.library.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	ModelMapper mapper;

	@Autowired
	TransactionService transactionService;

	/**
	 * To record transaction of a user while borrowing one or more articles
	 * 
	 * @param id
	 * @param articleTitles
	 * @return
	 */
	@PostMapping("borrowArticle/{userId}")
	public ResponseEntity<String> borrowArticle(@PathVariable(name = "userId", required = true) int id,
			@RequestBody(required = true) List<String> articleTitles) {
		return transactionService.borrowArticles(id, articleTitles);
	}

	/**
	 * To record transaction of a user while one or more articles is returned to the
	 * library
	 * 
	 * @param id
	 * @param articleTitles
	 * @return
	 */
	@PostMapping("returnArticle/{userId}")
	public ResponseEntity<String> returnArticle(@PathVariable(name = "userId", required = true) int id,
			@RequestBody(required = true) List<String> articleTitles) {
		return transactionService.returnArticles(id, articleTitles);
	}

	/**
	 * To get list of existing transactions in the database that were borrowed more
	 * than 30 days back and never returned
	 * 
	 * @return
	 */
	@GetMapping("getTransactionsExpiredDateOfReturn")
	public List<UserArticleTransactionDto> getTransactionsExpiredDateOfReturn() {
		List<UserArticleTransaction> transactions = transactionService.getTransactionsExpiredDateOfReturn();
		if (!transactions.isEmpty()) {
			return transactions.stream().map(item -> mapper.map(item, UserArticleTransactionDto.class))
					.collect(Collectors.toList());
		}
		return null;
	}
}
