package com.abcool.Library.Management.System.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abcool.Library.Management.System.entity.IssuedBook;

public interface IssuedBooksRepository extends JpaRepository<IssuedBook, Integer>{

	public IssuedBook getByissueID(Integer issueID);
	
	public IssuedBook getBybookName(String bookName);
	
	public IssuedBook getByfine(Integer fine);
	
	public IssuedBook getByissueDate(Date issueDate);
	
	public IssuedBook getByissuedTo(String issuedTo);
}
