package com.abcool.Library.Management.System.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookID;
	
	private String bookName;
	
	private String authorName;
	
	private String publisher;
	
	private int publishedYear;
	
	private int cost;
	
	private char isIssued;
	
	@ManyToOne
	@JoinColumn
	private BookCategory category;

	public Book() {
	}
	
	public Book(String bookName, String authorName, String publisher, int publishedYear, int cost,
			int categoryID) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.cost = cost;
		this.category = new BookCategory();
		this.category.setCategoryID(categoryID);
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public char getIsIssued() {
		return isIssued;
	}

	public void setIsIssued(char isIssued) {
		this.isIssued = isIssued;
	}

}
