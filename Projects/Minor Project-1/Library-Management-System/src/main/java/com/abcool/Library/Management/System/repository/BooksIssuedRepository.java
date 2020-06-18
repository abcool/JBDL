package com.abcool.Library.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.Library.Management.System.entity.BooksIssued;

public interface BooksIssuedRepository extends JpaRepository<BooksIssued, Integer>{

}
