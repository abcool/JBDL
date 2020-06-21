package com.abcool.Library.Management.System.DTOs;

public class BookResponseDTO {

	private int bookID;
	
	private String bookName;
	
	private String authorName;
	
	private String publisher;
	
	private int publishedYear;
	
	private int cost;
	
	private char isIssued;
	
	private String msg;

	public int getBookID() {
		return bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public int getCost() {
		return cost;
	}

	public char getIsIssued() {
		return isIssued;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setIsIssued(char isIssued) {
		this.isIssued = isIssued;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
