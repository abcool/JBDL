package com.abcool.Library.Management.System.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.Library.Management.System.DTOs.IssueBookRequestDTO;
import com.abcool.Library.Management.System.DTOs.IssuedBookResponseDTO;
import com.abcool.Library.Management.System.service.IssuedBooksService;

@RestController
public class IssuedBooksController {

	@Autowired
	IssuedBooksService service;
	
	@GetMapping(path="/allIssued",produces="application/json")
	public List<IssuedBookResponseDTO> allIssued(){
		return service.allIssued();
	}
	
	@GetMapping(path="/issued/{issueID}/{bookName}/{fine}/{issueDate}/{issuedTo}",produces="application/json")
	public IssuedBookResponseDTO issued(
			@PathVariable Integer issueID,
			@PathVariable String bookName,
			@PathVariable Integer fine,
			@PathVariable Date issueDate,
			@PathVariable String issuedTo) {
		return service.issued(issueID, bookName,fine, issueDate, issuedTo);
	}
	
	@PostMapping(path="/issueBook",consumes="application/json",produces="application/json")
	public IssuedBookResponseDTO issueBook(@RequestBody IssueBookRequestDTO dto){
		try {
		return service.issueBook(dto);
		}catch(Exception e) {
			return null;
		}
	}
}

