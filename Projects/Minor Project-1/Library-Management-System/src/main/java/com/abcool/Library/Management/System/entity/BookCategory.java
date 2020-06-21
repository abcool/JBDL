package com.abcool.Library.Management.System.entity;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryID;
	
	private String categoryName;
	
	private String description;

	@OneToMany(mappedBy= "category", cascade = CascadeType.ALL)
	private Set<Book> book;
	
	public BookCategory() {
		
	}

	
	public BookCategory(String categoryName, String desc, Set<Book> book) {
		this.categoryName = categoryName;
		this.description = desc;
		this.book = book;
		Iterator itr = book.iterator();
		while(itr.hasNext()) {
			Book b = (Book)itr.next();
			b.setCategory(this);
		}
	}
	
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Set<Book> getBook() {
		return book;
	}
	
}
