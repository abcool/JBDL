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
import com.abcool.Library.Management.System.repository.BookRepository;

@Service
public class BookCategoryService {

	@Autowired
	BookCategoryRepository repo;
	
	@Autowired
	BookRepository book_repo;
	
	public List<BookCategoryResponseDTO> getCategories(){
		List<BookCategory> category = repo.findAll();
		List<BookCategoryResponseDTO> response = new ArrayList<BookCategoryResponseDTO>();
		for(BookCategory b : category) {
			BookCategoryResponseDTO dto = new BookCategoryResponseDTO();
			dto.setCategoryID(b.getCategoryID());
			dto.setCategoryName(b.getCategoryName());
			dto.setDescription(b.getDescription());
			dto.setMsg(b.getCategoryName() + " Found");
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
			BookCategoryRequestDTO dto) {
			Set<Book> books = new HashSet<Book>();
			for(BookRequestDTO dt:dto.getListBookRequestDTO()) {
				Book b = new Book();
				b.setAuthorName(dt.getAuthorName());
				b.setBookName(dt.getBookName());
				b.setCost(dt.getCost());
				b.setPublishedYear(dt.getPublishedYear());
				b.setPublisher(dt.getPublisher());
				b.setIsIssued('N');
				books.add(b);
			}
			repo.save(new BookCategory(dto.getCategoryName(),dto.getDescription(), books));
			BookCategoryResponseDTO response = new BookCategoryResponseDTO();
			response.setMsg("New category along with some books successfully added");
			return response;
	}
	
	public BookCategoryResponseDTO updateBookCategoryName(BookCategoryRequestDTO dto) {
		int categoryID = dto.getCategoryID();
		String categoryName = dto.getCategoryName();
		BookCategoryResponseDTO response = new BookCategoryResponseDTO();
		Integer result = repo.updateBookCategoryName(categoryID, categoryName);
		if(result!=null) {			
			response.setMsg("Category Name successfully updated");
			return response;
		}else {
			response.setMsg("There occured some problem is renaming book category, please try again");
			return response;
		}
	}
	
	public BookCategoryResponseDTO updateBookCategoryDescription(BookCategoryRequestDTO dto) {
		int categoryID = dto.getCategoryID();
		String description = dto.getDescription();
		BookCategoryResponseDTO response = new BookCategoryResponseDTO();
		Integer result = repo.updateBookCategoryDescription(categoryID, description);
		if(result!=null) {
			response.setDescription("Category Description successfully updated");
			return response;
		}else {
			response.setMsg("There occured some problem in updating description of the mentioned category ID, please try again");
			return response;
		}
	}
	
	public BookCategoryResponseDTO bookCategoryWithBooks(BookCategoryRequestDTO dto) {
		BookCategoryResponseDTO response = new BookCategoryResponseDTO();
		if(dto!=null) {
			if(dto.getCategoryID()!=null) {
				BookCategory bc =  repo.findBycategoryID(dto.getCategoryID());
				List<Book> books = book_repo.findBycategory(bc);
				response.setBooks(books);
				response.setCategoryName(bc.getCategoryName());
				response.setDescription(bc.getDescription());
				response.setCategoryID(bc.getCategoryID());
				return response;
			}else if(dto.getCategoryName()!=null) {
				BookCategory bc =   repo.findBycategoryName(dto.getCategoryName());
				List<Book> books = book_repo.findBycategory(bc);
				response.setBooks(books);
				response.setCategoryName(bc.getCategoryName());
				response.setDescription(bc.getDescription());
				response.setCategoryID(bc.getCategoryID());
				return response;
			}else {
				response.setMsg("Only category ID or name is supported for searching, please try again");
				return response;
			}
		}else {
			response.setMsg("Please check the details entered");
			return response;
		}
	}
}
