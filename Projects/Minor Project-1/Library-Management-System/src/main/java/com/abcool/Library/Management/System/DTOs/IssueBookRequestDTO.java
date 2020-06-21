package com.abcool.Library.Management.System.DTOs;



public class IssueBookRequestDTO {

	private Integer issueID;
	
    private String issuedTo;
	
	private String issueDate;
	
	private String bookName;
	
	private Integer fine;

	public Integer getIssueID() {
		return issueID;
	}

	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}

	public String getIssuedTo() {
		return issuedTo;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public String getBookName() {
		return bookName;
	}

	public Integer getFine() {
		return fine;
	}

	public void setIssuedTo(String issuedTo) {
		this.issuedTo = issuedTo;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}
	
}
