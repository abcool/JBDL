package com.abcool.Library.Management.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.Library.Management.System.DTOs.BookCategoryRequestDTO;
import com.abcool.Library.Management.System.DTOs.BookCategoryResponseDTO;
import com.abcool.Library.Management.System.service.BookCategoryService;

@RestController
public class BookCategoryController {

	@Autowired
	BookCategoryService service;
	
	@GetMapping(path="/bookCategories", produces="application/json")
	public List<BookCategoryResponseDTO> bookCategories() {
		return service.getCategories();
	}
	
	@GetMapping(path="bookCategory/{categoryID}/{categoryName}", produces="application/json")
	public BookCategoryResponseDTO bookCategory(@PathVariable Integer categoryID, @PathVariable String categoryName) {
			return service.getCategory(categoryID, categoryName);
	}
	
	@PostMapping(path="/createBookCategory", consumes="application/json", produces="application/json")
	public BookCategoryResponseDTO createBookCategory(@RequestBody BookCategoryRequestDTO dto) {
		return service.insertCategory(dto);
	}
	
	@PostMapping(path="/enterCategoryWithBooks", consumes="application/json", produces="application/json")
	public BookCategoryResponseDTO enterCategoryWithBooks(
			@RequestBody BookCategoryRequestDTO dto) {
		return service.enterCategoryWithBooks(dto);
	}
	@PutMapping(path="/updateBookCategoryName", consumes="application/json", produces="application/json")
	public BookCategoryResponseDTO updateBookCategoryName(@RequestBody BookCategoryRequestDTO dto) {
		return service.updateBookCategoryName(dto);
	}
	
	@PutMapping(path="/updateBookCategoryDescription", consumes="application/json", produces="application/json")
	public BookCategoryResponseDTO updateBookCategoryDescription(@RequestBody BookCategoryRequestDTO dto) {
		return service.updateBookCategoryDescription(dto);
	}
}
