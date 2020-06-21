package com.abcool.Library.Management.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path="/book")
	public BookResponseDTO book(@RequestBody BookRequestDTO dto) {
		return service.getBook(dto);
	}
	
	@PostMapping(path="/insertBook",consumes="application/json",produces="application/json")
	public BookResponseDTO insertBook(@RequestBody BookRequestDTO dto) {
		return service.insertBook(dto);
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
	
	@PutMapping(path="/updateCost",consumes="application/json",produces="application/json")
	public BookResponseDTO updateCost(@RequestBody BookRequestDTO dto) {
		return service.updateCost(dto);
	}
	
	@DeleteMapping(path="/deleteBook/{bookID}",produces="application/json")
	public BookResponseDTO deleteBook(@PathVariable Integer bookID) {
		return service.deleteBook(bookID);
	}
}
