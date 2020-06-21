package com.abcool.Library.Management.System.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abcool.Library.Management.System.entity.Book;
import com.abcool.Library.Management.System.entity.BookCategory;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public Book findByauthorName(String authorName);
	
	public Book findBybookName(String bookName);
	
	public Book findBypublisher(String publisher);
	
	public Book findBypublishedYear(Integer year);
	
	public Book findBycost(Integer cost);
	
	public Book findBybookID(Integer bookID);
	
	public List<Book> findBycategory(BookCategory category);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.bookName=:bookName where b.bookID=:bookID")
	public Integer updateBookName(Integer bookID, String bookName);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.authorName=:authorName where b.bookID=:bookID")
	public Integer updateAuthorName(Integer bookID, String authorName);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.publisher=:publisher where b.bookID=:bookID")
	public Integer updatePublisher(Integer bookID, String publisher);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.publishedYear=:publishedYear where b.bookID=:bookID")
	public Integer updatePublishedYear(Integer bookID, Integer publishedYear);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.cost=:cost where b.bookID=:bookID")
	public Integer updateCost(Integer bookID, Integer cost);
	
	@Transactional
	@Modifying
	@Query("update Book b set b.isIssued=:isIssued where b.bookID=:bookID")
	public Integer updateisIssued(Integer bookID, char isIssued);
}
