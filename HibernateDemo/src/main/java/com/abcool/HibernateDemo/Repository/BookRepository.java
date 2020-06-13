package com.abcool.HibernateDemo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abcool.HibernateDemo.Models.Books;

public interface BookRepository extends JpaRepository<Books,Integer>{
	
	/* @Query("select * from book where book.name = name")
	List<Books> findByName(String name);*/
	
	public List<Books> findByAuthorName(String name);

	public List<Books> findByCost(int cost);
	
	public Books findById(int id);
	
	@Query(value="select * from books b where b.id=:id", nativeQuery=true)
	public Books IdSearch(int id);
	
	@Query(value="select b from Books b where b.authorName=:author")
	public List<Books> lookByAuthor(String author);
}
