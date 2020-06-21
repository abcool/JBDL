package com.abcool.Library.Management.System.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class IssuedBook {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int issueID;
	
	private String issuedTo;
	
	private Date issueDate;
	
	private String bookName;
	
	private int fine;
	

	public IssuedBook(String issuedTo, Date issueDate, String bookName, int fine) {
		this.issuedTo = issuedTo;
		this.issueDate = issueDate;
		this.bookName = bookName;
		this.fine = fine;
	}

	public int getIssueID() {
		return issueID;
	}

	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public void setIssuedTo(String issuerName) {
		this.issuedTo = issuerName;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
