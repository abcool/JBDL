package com.abcool.Library.Management.System.DTOs;



public class IssueBookRequestDTO {

    private String issuedTo;
	
	private String issueDate;
	
	private String bookName;
	
	private int fine;

	public String getIssuedTo() {
		return issuedTo;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public String getBookName() {
		return bookName;
	}

	public int getFine() {
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

	public void setFine(int fine) {
		this.fine = fine;
	}
	
}
