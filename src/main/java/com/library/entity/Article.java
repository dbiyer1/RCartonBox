package com.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.Hidden;

@Table
@Entity
public class Article {

	/**
	 * Sequence Generator added to have auto-incremented id set for every new article
	 */
	@Id
	@SequenceGenerator(name = "articleSeq", sequenceName = "articleSeq", initialValue = 100)
	@GeneratedValue(generator = "articleSeq")
	@Hidden
	private Integer id;

	/**
	 * Constraint added to ensure TITLE of every article is unique
	 */
	@Column(unique = true)
	private String title;

	@Column
	private String type;

	@Column
	private String author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
