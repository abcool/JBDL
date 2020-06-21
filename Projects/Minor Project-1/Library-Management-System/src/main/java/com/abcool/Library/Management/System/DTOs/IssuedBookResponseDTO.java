package com.abcool.Library.Management.System.DTOs;

import java.util.Date;

public class IssuedBookResponseDTO {

	private String issuedTo;
	
	private Date issueDate;
	
	private String bookName;
	
	private int fine;
	
	private String msg;

	public String getIssuedTo() {
		return issuedTo;
	}

	public Date getIssueDate() {
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

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
