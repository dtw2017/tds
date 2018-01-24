package com.example.readinglist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // persistent entity class must have at least the @Entity annotation.
		// Hibernate maps this class to a table called BOOK..
@Table(name = "book")
public class Book {
	@Id // Every persistent entity class must have an identifier attribute
		// annotated with @Id.
		// Hibernate maps this attribute to a column named ID.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reader;
	private String isbn;

	@NotNull
	@Size(min = 2, max = 10)
	private String title;
	private String author;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
