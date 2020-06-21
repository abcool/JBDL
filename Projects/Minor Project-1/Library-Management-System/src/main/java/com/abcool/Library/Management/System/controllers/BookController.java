package com.abcool.Library.Management.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.Library.Management.System.DTOs.BookRequestDTO;
import com.abcool.Library.Management.System.DTOs.BookResponseDTO;
import com.abcool.Library.Management.System.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping(path="/books", produces="application/json")
	public List<BookResponseDTO> books() {
		return service.getBooks();
	}
	
	@GetMapping(path="/book/{authorName}/{bookName}/{cost}/{publishedYear}/{publisher}")
	public BookResponseDTO book(
			@PathVariable String authorName, 
			@PathVariable String bookName,
			@PathVariable Integer cost, 
			@PathVariable Integer publishedYear,
			@PathVariable String publisher) {
		return service.getBook(authorName, bookName, cost, publishedYear, publisher);
	}
	
	@PostMapping(path="/insertBook/{categoryID}/{categoryName}",consumes="application/json",produces="application/json")
	public BookResponseDTO insertBook(
			@PathVariable(value="categoryID") Integer categoryID, 
			@PathVariable(value="categoryName") String categoryName, 
			@RequestBody BookRequestDTO dto) {
		return service.insertBook(categoryID,categoryName,dto);
	}
	
	@PutMapping(path="/updateBookName")
	public BookResponseDTO updateBookName(@RequestBody BookRequestDTO dto) {
		return service.updateBookName(dto);
	}
	
	@PutMapping(path="/updateAuthorName")
	public BookResponseDTO updateAuthorName(@RequestBody BookRequestDTO dto) {
		return service.updateAuthorName(dto);
	}
	
	@PutMapping(path="/updatePublisher")
	public BookResponseDTO updatePublisher(@RequestBody BookRequestDTO dto) {
		return service.updatePublisher(dto);
	}
	
	@PutMapping(path="/updatePublishedYear")
	public BookResponseDTO updatePublishedYear(@RequestBody BookRequestDTO dto) {
		return service.updatePublishedYear(dto);
	}
	
	@PutMapping(path="/updateCost")
	public BookResponseDTO updateCost(@RequestBody BookRequestDTO dto) {
		return service.updateCost(dto);
	}
}
