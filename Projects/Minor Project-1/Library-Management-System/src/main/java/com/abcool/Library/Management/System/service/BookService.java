package com.abcool.Library.Management.System.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcool.Library.Management.System.repository.BookCategoryRepository;
import com.abcool.Library.Management.System.DTOs.BookRequestDTO;
import com.abcool.Library.Management.System.DTOs.BookResponseDTO;
import com.abcool.Library.Management.System.entity.Book;
import com.abcool.Library.Management.System.repository.BookRepository;
import com.abcool.Library.Management.System.repository.IssuedBooksRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repo;
	
	@Autowired
	BookCategoryRepository categoryRepo;
	
	public List<BookResponseDTO> getBooks() {
		List<BookResponseDTO> response = new ArrayList<BookResponseDTO>();
		List<Book> books = repo.findAll();
		if(books!=null) {
			for(Book b:books) {
				BookResponseDTO dt = new BookResponseDTO();
				dt.setBookName(b.getBookName());
				dt.setAuthorName(b.getAuthorName());
				dt.setCost(b.getCost());
				dt.setPublisher(b.getPublisher());
				dt.setPublishedYear(b.getPublishedYear());
				dt.setIsIssued(b.getIsIssued());
				response.add(dt);
				
			}
			return response;
		}else {
			BookResponseDTO dto = new BookResponseDTO();
			dto.setMsg("Sorry no books found");
			response.add(dto);
			return response;
		}
	}
	
	public BookResponseDTO getBook(BookRequestDTO dto) {
		BookResponseDTO response = new BookResponseDTO();
		String authorName = dto.getAuthorName();
		String bookName = dto.getBookName();
		Integer cost = dto.getCost();
		Integer publishedYear = dto.getPublishedYear();
		String publisher = dto.getPublisher();
		if(authorName!=null) {
			Book b = repo.findByauthorName(authorName);
			response.setAuthorName(b.getAuthorName());
			response.setBookName(b.getBookName());
			response.setCost(b.getCost());
			response.setIsIssued(b.getIsIssued());
			response.setPublishedYear(b.getPublishedYear());
			response.setPublisher(b.getPublisher());
			response.setMsg("Found");
			return response;
		}else if(bookName!=null) {
			Book b = repo.findBybookName(bookName);
			response.setAuthorName(b.getAuthorName());
			response.setBookName(b.getBookName());
			response.setCost(b.getCost());
			response.setIsIssued(b.getIsIssued());
			response.setPublishedYear(b.getPublishedYear());
			response.setPublisher(b.getPublisher());
			response.setMsg("Found");
			return response;
		}else if(cost!=null) {
			Book b = repo.findBycost(cost);
			response.setAuthorName(b.getAuthorName());
			response.setBookName(b.getBookName());
			response.setCost(b.getCost());
			response.setIsIssued(b.getIsIssued());
			response.setPublishedYear(b.getPublishedYear());
			response.setPublisher(b.getPublisher());
			response.setMsg("Found");
			return response;
		}else if(publishedYear!=null) {
			Book b = repo.findBypublishedYear(publishedYear);
			response.setAuthorName(b.getAuthorName());
			response.setBookName(b.getBookName());
			response.setCost(b.getCost());
			response.setIsIssued(b.getIsIssued());
			response.setPublishedYear(b.getPublishedYear());
			response.setPublisher(b.getPublisher());
			response.setMsg("Found");
			return response;
		}else if(publisher!=null) {
			Book b = repo.findBypublisher(publisher);
			response.setAuthorName(b.getAuthorName());
			response.setBookName(b.getBookName());
			response.setCost(b.getCost());
			response.setIsIssued(b.getIsIssued());
			response.setPublishedYear(b.getPublishedYear());
			response.setPublisher(b.getPublisher());
			response.setMsg("Found");
			return response;
		}else {
			response.setMsg("Sorry not books found");
			return response;
		}
	}
	
	public BookResponseDTO insertBook(BookRequestDTO dto) {
		BookResponseDTO response = new BookResponseDTO();
		Integer cID;
		String categoryName = dto.getCategoryName();
		Integer categoryID = dto.getCategoryID();
		if(categoryName!=null) {
			cID = categoryRepo.findBycategoryID(categoryName);
		}else {
			cID = categoryID;
		}
		if(dto!=null) {
			Book b = new Book(dto.getBookName(),dto.getAuthorName(),dto.getPublisher(),
					          dto.getPublishedYear(),dto.getCost(),cID ,'N');
			if(repo.findBybookName(dto.getBookName())==null) {
			repo.save(b);
			response.setMsg("Book saved successfully");
			return response;
			}else {
				response.setMsg("Books already exists");
				return response;
			}
		}else {
			response.setMsg("There occured a problem while saving book details, kindly check enter details");
			return response;
		}
	}
	
	public BookResponseDTO updateBookName(BookRequestDTO dto) {
		BookResponseDTO response = new BookResponseDTO();
		if(dto!=null) {
			Integer bookID = dto.getBookID();
			String bookName = dto.getBookName();
			Integer result = repo.updateBookName(bookID, bookName);
			if(result!=null) {
				response.setMsg("Updated book name successfully");
				return response;
			}else {
				response.setMsg("There was some problem in updating book name");
				return response;
			}
		}else {
			response.setMsg("Please check the details provided");
			return response;
		}
	}
	
	public BookResponseDTO updateAuthorName(BookRequestDTO dto) {
		BookResponseDTO response = new BookResponseDTO();
		if(dto!=null) {
			Integer bookID = dto.getBookID();
			String authorName = dto.getAuthorName();
			Integer result = repo.updateAuthorName(bookID, authorName);
			if(result!=null) {
				response.setMsg("Book name updated successfully");
				return response;
			}else {
				response.setMsg("There was a problem updating book name");
				return response;
			}
		}else {
			response.setMsg("Please check the details entered");
			return response;
		}
	}
	
	public BookResponseDTO updatePublisher(BookRequestDTO dto) {
		BookResponseDTO response = new BookResponseDTO();
		if(dto!=null) {
			Integer bookID = dto.getBookID();
			String publisher = dto.getPublisher();
			Integer result = repo.updatePublisher(bookID, publisher);
			if(result!=null) {
				response.setMsg("Publisher updated successfully");
				return response;
			}else {
				response.setMsg("There was a problem updating publisher name");
				return response;
			}
		}else {
			response.setMsg("Please check the details entered");
			return response;
		}
	}
	
	public BookResponseDTO updatePublishedYear(BookRequestDTO dto) {
		BookResponseDTO response = new BookResponseDTO();
		if(dto!=null) {
			Integer bookID = dto.getBookID();
			Integer publishedYear = dto.getPublishedYear();
			Integer result = repo.updatePublishedYear(bookID, publishedYear);
			if(result!=null) {
				response.setMsg("Published year updated successfully");
				return response;
			}else {
				response.setMsg("There was a problem updating published year");
				return response;
			}
		}else {
			response.setMsg("Please check the details entered");
			return response;
		}
	}
	
	public BookResponseDTO updateCost(BookRequestDTO dto) {
		BookResponseDTO response = new BookResponseDTO();
		if(dto!=null) {
			Integer bookID = dto.getBookID();
			Integer cost = dto.getCost();
			Integer result = repo.updateCost(bookID, cost);
			if(result!=null) {
				response.setMsg("Cost updated successfully");
				return response;
			}else {
				response.setMsg("There was a problem updating cost");
				return response;
			}
		}else {
			response.setMsg("Please check the details entered");
			return response;
		}
	}
	
	public BookResponseDTO deleteBook(Integer bookID) {
		BookResponseDTO response = new BookResponseDTO();
		Book b = repo.findBybookID(bookID);
		char isIssued = b.getIsIssued();
		if(isIssued=='Y') {
			response.setMsg("Book is issued, please return the book before deleting");
			return response;
		}else {
			repo.delete(b);
			response.setMsg("Book " +"\""+b.getBookName() +"\"" + " successfully removed from the library");
			return response;
		}
	}
}
