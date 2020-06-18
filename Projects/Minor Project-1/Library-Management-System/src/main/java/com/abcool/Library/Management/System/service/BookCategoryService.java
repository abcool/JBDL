package com.abcool.Library.Management.System.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcool.Library.Management.System.DTOs.BookCategoryRequestDTO;
import com.abcool.Library.Management.System.DTOs.BookCategoryResponseDTO;
import com.abcool.Library.Management.System.DTOs.BookRequestDTO;
import com.abcool.Library.Management.System.entity.Book;
import com.abcool.Library.Management.System.entity.BookCategory;
import com.abcool.Library.Management.System.repository.BookCategoryRepository;

@Service
public class BookCategoryService {

	@Autowired
	BookCategoryRepository repo;
	
	public List<BookCategoryResponseDTO> getCategories(){
		List<BookCategory> category = repo.findAll();
		List<BookCategoryResponseDTO> response = new ArrayList<BookCategoryResponseDTO>();
		for(BookCategory b : category) {
			BookCategoryResponseDTO dto = new BookCategoryResponseDTO();
			dto.setCategoryID(b.getCategoryID());
			dto.setCategoryName(b.getCategoryName());
			dto.setDescription(b.getDescription());
			dto.setMsg(b.getCategoryName() + "Found");
			response.add(dto);
		}
		return response;
	}
	
	public BookCategoryResponseDTO getCategory(Integer categoryID, String categoryName) {
		BookCategoryResponseDTO response = new BookCategoryResponseDTO();
		if(categoryID!=null) {
			BookCategory bc = repo.findBycategoryID(categoryID);
			response.setCategoryID(bc.getCategoryID());
			response.setCategoryName(bc.getCategoryName());
			response.setDescription(bc.getDescription());
			response.setMsg(bc.getCategoryName() + "Found");
			return response;
		}else if(categoryName!=null){
			BookCategory bc = repo.findBycategoryName(categoryName);
			response.setCategoryID(bc.getCategoryID());
			response.setCategoryName(bc.getCategoryName());
			response.setDescription(bc.getDescription());
			response.setMsg(bc.getCategoryName() + "Found");
			return response;
		}else {
			response.setMsg("No such Book Category Found");
			return response;
		}		
	}
	
	public BookCategoryResponseDTO insertCategory(BookCategoryRequestDTO dto) {
		BookCategory bc = new BookCategory();
		bc.setCategoryName(dto.getCategoryName());
		bc.setDescription(dto.getDescription());
		repo.save(bc);
		BookCategoryResponseDTO response = new BookCategoryResponseDTO();
		response.setMsg("New Category created successfully");
		return response;
	}
	
	public BookCategoryResponseDTO enterCategoryWithBooks(
			String categoryName,
			String desc,
			List<BookRequestDTO> dtos) {
			Set<Book> books = new HashSet<Book>();
			for(BookRequestDTO dt:dtos) {
				Book b = new Book();
				b.setAuthorName(dt.getAuthorName());
				b.setBookName(dt.getBookName());
				b.setCost(dt.getCost());
				b.setPublishedYear(dt.getPublishedYear());
				b.setPublisher(dt.getPublisher());
				books.add(b);
			}
			repo.save(new BookCategory(categoryName,desc, books));
			BookCategoryResponseDTO response = new BookCategoryResponseDTO();
			response.setMsg("New category along with some books successfully added");
			return response;
	}
}
