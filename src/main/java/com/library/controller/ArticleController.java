package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Article;
import com.library.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@GetMapping("getArticles")
	public List<Article> getArticles() {
		return articleService.getArticles();
	}

	@PostMapping("addArticle")
	public ResponseEntity<String> addArticle(@RequestBody Article article) {
		articleService.addArticle(article);
		return new ResponseEntity<String>("Article Saved Successfully", HttpStatus.OK);
	}

	@DeleteMapping("deleteArticle/{id}")
	public ResponseEntity<String> deleteArticle(@PathVariable(value = "id") int id) {
		boolean response = articleService.deleteArticle(id);
		if (response) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deletion failed. Please check ID", HttpStatus.BAD_REQUEST);
	}
}
