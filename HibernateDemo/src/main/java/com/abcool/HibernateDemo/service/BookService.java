package com.abcool.HibernateDemo.service;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcool.HibernateDemo.Models.BookCategory;
import com.abcool.HibernateDemo.Models.Books;
import com.abcool.HibernateDemo.Repository.BookCategoryRepository;
import com.abcool.HibernateDemo.Repository.BookRepository;

@Service
public class BookService {
	
	
	@Autowired
	BookRepository repo;
	
	@Autowired
	BookCategoryRepository category_repo;
	
	public void addCategory(String categoryName) {
		category_repo.save(new BookCategory(categoryName));
	}
	
	public void addCategoryWithBooks(String cName, Set<Books> b) {
		category_repo.save(new BookCategory(cName, b));
	}
	
	public List<Books> getAllBooks(){
		return repo.findAll();
	}
	
	public void saveBook(Books book) {
		repo.save(book);
	}
	
	public List<Books> findByAuthor(String author) {
		return repo.findByAuthorName(author);
	}
	
	public List<Books> searchByCost(int cost){
		return repo.findByCost(cost);
	}
	
	public Books searchById(int id) {
		//return repo.findById(id);
		return repo.IdSearch(id);
	}
	
	public List<Books> lookByAuthor(String author) {
		return repo.lookByAuthor(author);
	}
}
