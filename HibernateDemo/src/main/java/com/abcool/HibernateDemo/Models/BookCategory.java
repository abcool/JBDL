package com.abcool.HibernateDemo.Models;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookCategory {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	private String categoryName;
	
	@OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
	private Set<Books> book;
	
	
	public BookCategory(String categoryName) {
		this.categoryName = categoryName;
	}

	public BookCategory(String categoryName, Set<Books> book) {
		this.categoryName = categoryName;
		this.book = book;
		Iterator itr = book.iterator();
		while(itr.hasNext()) {
			Books bk = (Books)itr.next();
			bk.setCategory(this);
		}
	}

	public Set<Books> getBook() {
		return book;
	}

	public void setBook(Set<Books> book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
}
