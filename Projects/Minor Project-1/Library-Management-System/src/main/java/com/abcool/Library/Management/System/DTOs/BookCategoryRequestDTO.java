package com.abcool.Library.Management.System.DTOs;

import java.util.List;

public class BookCategoryRequestDTO {

	private int categoryID;
	
	private String categoryName;
	
	private String description;
	
	private BookRequestDTO bookRequestDTO;
	
	private List<BookRequestDTO> listBookRequestDTO;

	public int getCategoryID() {
		return categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BookRequestDTO getBookRequestDTO() {
		return bookRequestDTO;
	}

	public void setBookRequestDTO(BookRequestDTO bookRequestDTO) {
		this.bookRequestDTO = bookRequestDTO;
	}

	public List<BookRequestDTO> getListBookRequestDTO() {
		return listBookRequestDTO;
	}

	public void setListBookRequestDTO(List<BookRequestDTO> listBookRequestDTO) {
		this.listBookRequestDTO = listBookRequestDTO;
	}
	
}
