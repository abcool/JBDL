package com.abcool.Library.Management.System.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(path="/issued/",produces="application/json")
	public IssuedBookResponseDTO issued(@RequestBody IssueBookRequestDTO dto) {
		return service.issued(dto);
	}
	
	@PostMapping(path="/issueBook",consumes="application/json",produces="application/json")
	public IssuedBookResponseDTO issueBook(@RequestBody IssueBookRequestDTO dto){
		try {
		return service.issueBook(dto);
		}catch(Exception e) {
			return null;
		}
	}
	
	@PutMapping(path="/updateIssueBookName", consumes="application/json", produces="application/json")
	public IssuedBookResponseDTO updateIssueBookName(@RequestBody IssueBookRequestDTO dto) {
		return service.updateIssueBookName(dto);
	}
	
	@PutMapping(path="/updateIssueDate", consumes="application/json", produces="application/json")
	public IssuedBookResponseDTO updateIssueDate(@RequestBody IssueBookRequestDTO dto) {
		return service.updateIssueDate(dto);
	}
	
	@PutMapping(path="/updateIssuedTo", consumes="application/json", produces="application/json")
	public IssuedBookResponseDTO updateIssuedTo(@RequestBody IssueBookRequestDTO dto) {
		return service.updateIssuedTo(dto);
	}
}

