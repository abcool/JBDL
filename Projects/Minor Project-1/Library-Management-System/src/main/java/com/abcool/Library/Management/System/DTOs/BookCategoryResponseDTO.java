package com.abcool.Library.Management.System.DTOs;

import java.util.List;

import com.abcool.Library.Management.System.entity.Book;

public class BookCategoryResponseDTO {

	private int categoryID;
	
	private String categoryName;
	
	private String description;
	
	private String msg;
	
	private List<Book> books;

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
