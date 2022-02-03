package com.library.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.ArticleDto;
import com.library.entity.Article;
import com.library.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@Autowired
	ModelMapper mapper;

	/**
	 * To get list of all existing articles in the database
	 * 
	 * @return
	 */
	@GetMapping("getArticles")
	public List<ArticleDto> getArticles() {
		List<Article> articles = articleService.getArticles();
		if (!articles.isEmpty()) {
			return articles.stream().map(item -> mapper.map(item, ArticleDto.class)).collect(Collectors.toList());
		}
		return null;
	}

	/**
	 * To add a new article to the database
	 * 
	 * @param articleDto
	 * @return
	 */
	@PostMapping("addArticle")
	public ResponseEntity<String> addArticle(@RequestBody ArticleDto articleDto) {
		articleService.addArticle(mapper.map(articleDto, Article.class));
		return new ResponseEntity<String>("Article Saved Successfully", HttpStatus.OK);
	}

	/**
	 * To delete an existing article from the database
	 * 
	 * @param user
	 * @return
	 */
	@DeleteMapping("deleteArticle/{id}")
	public ResponseEntity<String> deleteArticle(@PathVariable(value = "id") int id) {
		boolean response = articleService.deleteArticle(id);
		if (response) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deletion failed. Please check ID", HttpStatus.BAD_REQUEST);
	}
}
