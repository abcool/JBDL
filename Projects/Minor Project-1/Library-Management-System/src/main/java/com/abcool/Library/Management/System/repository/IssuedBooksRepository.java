package com.abcool.Library.Management.System.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.abcool.Library.Management.System.entity.IssuedBook;

public interface IssuedBooksRepository extends JpaRepository<IssuedBook, Integer>{

	public IssuedBook findByissueID(Integer issueID);
	
	public IssuedBook findBybookName(String bookName);
	
	public IssuedBook findByfine(Integer fine);
	
	public IssuedBook findByissueDate(Date issueDate);
	
	public IssuedBook findByissuedTo(String issuedTo);
	
	@Transactional
	@Modifying
	@Query("update IssuedBook ib set ib.bookName=:bookName where ib.issueID=:issueID")
	public Integer updateIssueBookName(String bookName, Integer issueID);
	
	@Transactional
	@Modifying
	@Query("update IssuedBook ib set ib.issueDate=:issueDate where ib.issueID=:issueID")
	public Integer updateIssueDate(Date issueDate, Integer issueID);
	
	@Transactional
	@Modifying
	@Query("update IssuedBook ib set ib.issuedTo=:issuedTo where ib.issueID=:issueID")
	public Integer updateIssuedTo(String issuedTo, Integer issueID);
}
