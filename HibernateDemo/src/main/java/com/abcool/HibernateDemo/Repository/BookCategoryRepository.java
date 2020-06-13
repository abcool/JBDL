package com.abcool.HibernateDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.HibernateDemo.Models.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{

}
