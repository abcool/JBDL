package com.abcool.Library.Management.System.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abcool.Library.Management.System.entity.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{

	public BookCategory findBycategoryID(Integer categoryID);
	
	public BookCategory findBycategoryName(String categoryName);
	
	
	@Modifying
	@Query("select bc.categoryID from BookCategory bc where bc.categoryName=:categoryName")
	public Integer findBycategoryID(String categoryName);
	
	@Transactional
	@Modifying
	@Query("update BookCategory bc set bc.categoryName=:categoryName where bc.categoryID=:categoryID")
	public Integer updateBookCategoryName(int categoryID, String categoryName);
	
	@Transactional
	@Modifying
	@Query("update BookCategory bc set bc.description=:description where bc.categoryID=:categoryID")
	public Integer updateBookCategoryDescription(int categoryID, String description);
}
