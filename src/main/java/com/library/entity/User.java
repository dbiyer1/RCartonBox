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
public class User {

	/**
	 * Sequence Generator added to have auto-incremented id set for every new user
	 */
	@Id
	@SequenceGenerator(name = "userSeq", sequenceName = "userSeq", initialValue = 100)
	@GeneratedValue(generator = "userSeq")
	@Hidden
	private Integer id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
