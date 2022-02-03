package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

	Optional<Article> findByTitle(String title);

}
