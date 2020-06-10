package com.abcool.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abcool.Models.Books;

public interface BookRepository extends JpaRepository<Books,Integer>{
	
	/* @Query("select * from book where book.name = name")
	List<Books> findByName(String name); */

}
