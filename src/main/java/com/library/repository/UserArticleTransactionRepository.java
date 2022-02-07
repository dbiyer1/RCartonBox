package com.library.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.entity.Article;
import com.library.entity.User;
import com.library.entity.UserArticleTransaction;

@Repository
public interface UserArticleTransactionRepository extends JpaRepository<UserArticleTransaction, Integer> {

	List<UserArticleTransaction> findByUser(User user);

	@Query(value = "Select u from UserArticleTransaction u where u.returnedOn IS NULL and u.user = :user and u.article = :article")
	UserArticleTransaction getItem(@Param("user") User user, @Param("article") Article article);

	@Query("Select u from UserArticleTransaction u where u.returnedOn IS NULL")
	List<UserArticleTransaction> findArticlesNotReturned();
}
