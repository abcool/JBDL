package com.abcool.Library.Management.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.Library.Management.System.DTOs.BookCategoryRequestDTO;
import com.abcool.Library.Management.System.DTOs.BookCategoryResponseDTO;
import com.abcool.Library.Management.System.DTOs.BookRequestDTO;
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
	
	@PostMapping(path="/enterCategory", consumes="application/json", produces="application/json")
	public BookCategoryResponseDTO enterCategory(@RequestBody BookCategoryRequestDTO dto) {
		return service.insertCategory(dto);
	}
	
	@PostMapping(path="enterCategoryWithBooks/{categoryName}/{desc}", consumes="application/json", produces="application/json")
	public BookCategoryResponseDTO enterCategoryWithBooks(
			@PathVariable String categoryName,
			@PathVariable String desc,
			@RequestBody List<BookRequestDTO> dtos) {
		return service.enterCategoryWithBooks(categoryName, desc, dtos);
	}
}
