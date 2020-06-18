package com.abcool.Library.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.Library.Management.System.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
