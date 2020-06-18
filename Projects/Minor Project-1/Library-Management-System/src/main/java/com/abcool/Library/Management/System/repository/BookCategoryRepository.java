package com.abcool.Library.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.Library.Management.System.entity.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{

	public BookCategory findBycategoryID(Integer categoryID);
	
	public BookCategory findBycategoryName(String categoryName);
}
