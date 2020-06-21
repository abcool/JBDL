package com.abcool.Library.Management.System.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcool.Library.Management.System.DTOs.IssueBookRequestDTO;
import com.abcool.Library.Management.System.DTOs.IssuedBookResponseDTO;
import com.abcool.Library.Management.System.entity.IssuedBook;
import com.abcool.Library.Management.System.repository.BookRepository;
import com.abcool.Library.Management.System.repository.IssuedBooksRepository;
import com.abcool.Library.Management.System.utilities.StringToDateConverter;

@Service
public class IssuedBooksService {

	@Autowired
	IssuedBooksRepository repo;
	
	@Autowired
	BookRepository book_repo;
	
	public List<IssuedBookResponseDTO> allIssued(){
		List<IssuedBookResponseDTO> response = new ArrayList<IssuedBookResponseDTO>();
		List<IssuedBook> ibooks = repo.findAll();
		if(ibooks!=null) {
		for(IssuedBook b:ibooks) {
			IssuedBookResponseDTO dto = new IssuedBookResponseDTO();
			dto.setBookName(b.getBookName());
			dto.setFine(b.getFine());
			dto.setIssueDate(b.getIssueDate());
			dto.setIssuedTo(b.getIssuedTo());
			response.add(dto);
		}
		return response;
		}else {
			IssuedBookResponseDTO dto = new IssuedBookResponseDTO();
			dto.setMsg("Sorry, no books have been issued yet");
			return response;
		}
	}
	
	public IssuedBookResponseDTO issued(Integer issueID, String bookName,
			Integer fine, Date issueDate, String issuedTo) {
		IssuedBookResponseDTO response = new IssuedBookResponseDTO();
		if(issueID!=null) {
			IssuedBook ibook = repo.getByissueID(issueID);
			if(ibook!=null) {
			response.setBookName(ibook.getBookName());
			response.setFine(ibook.getFine());
			response.setIssueDate(ibook.getIssueDate());
			response.setIssuedTo(ibook.getIssuedTo());
			return response;
			}else {
				response.setMsg("Sorry not book issued with specified issue ID");
				return response;
			}
		}else if(bookName!=null) {
			IssuedBook ibook = repo.getBybookName(bookName);
			if(ibook!=null) {
			response.setBookName(ibook.getBookName());
			response.setFine(ibook.getFine());
			response.setIssueDate(ibook.getIssueDate());
			response.setIssuedTo(ibook.getIssuedTo());
			return response;
			}else {
				response.setMsg("Sorry no book issued with specified book name");
				return response;
			}
		}else if(fine!=null) {
			IssuedBook ibook = repo.getByfine(fine);
			if(ibook!=null) {
			response.setBookName(ibook.getBookName());
			response.setFine(ibook.getFine());
			response.setIssueDate(ibook.getIssueDate());
			response.setIssuedTo(ibook.getIssuedTo());
			return response;
			}else {
				response.setMsg("Sorry no book issued with specified fine amount standing");
				return response;
			}
		}else if(issueDate!=null) {
			IssuedBook ibook = repo.getByissueDate(issueDate);
			if(ibook!=null) {
			response.setBookName(ibook.getBookName());
			response.setFine(ibook.getFine());
			response.setIssueDate(ibook.getIssueDate());
			response.setIssuedTo(ibook.getIssuedTo());
			return response;
			}else {
				response.setMsg("Sorry no book issued with specified issue date");
				return response;
			}
		}else if(issuedTo!=null) {
			IssuedBook ibook = repo.getByissuedTo(issuedTo);
			if(ibook!=null) {
			response.setBookName(ibook.getBookName());
			response.setFine(ibook.getFine());
			response.setIssueDate(ibook.getIssueDate());
			response.setIssuedTo(ibook.getIssuedTo());
			return response;
			}else {
				response.setMsg("Sorry no book issued to specified user");
				return response;
			}
		}
		response.setMsg("Please check the entered details");
		return response;
	}
	
	public IssuedBookResponseDTO issueBook(IssueBookRequestDTO dto) throws ParseException{
		IssuedBookResponseDTO response = new IssuedBookResponseDTO();
		Date date = StringToDateConverter.stringToDateConverter(dto.getIssueDate());
		if(dto!=null) {
			IssuedBook ibook = repo.save(new IssuedBook(dto.getIssuedTo(), date, dto.getBookName(), 0));
			Integer bookID = book_repo.findBybookName(dto.getBookName()).getBookID();
			Integer result= book_repo.updateisIssued(bookID, 'Y');
			if(result!=null) {
			response.setMsg(ibook.getBookName() + " Book Issued successfully to " + ibook.getIssuedTo());
			return response;
			}else {
				response.setMsg("There occured a problem while issuing book, please try again later");
				return response;
			}
		}else {
			response.setMsg("Please check entered details");
			return response;
		}
	}
}
