package com.abcool.HibernateDemo.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abcool.HibernateDemo.Models.Books;

import com.abcool.HibernateDemo.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService b;
	
    /**@author Arvind
     * @apiNote This method creates a new book category. 
     * 
     * */
	@PostMapping("/addCategory/{categoryName}")
	public void addCategory(@PathVariable String categoryName) {
		b.addCategory(categoryName);
	}
	
	/**@author Arvind
     * @apiNote This method creates a new book category with some books inserted. 
     * 
     * */
	@PostMapping("/addCategoryWithBooks")
	public void addCategoryWithBooks(@RequestBody String cName, Set<Books> books) {
		b.addCategoryWithBooks(cName, books);
	}
	
	@GetMapping("/getBooks")
	public List<Books> getBooks(){
		return b.getAllBooks();
	}
	
	@PostMapping("/enterBook")
	public void enterBook(@RequestBody Books book) {
		b.saveBook(book);
	}
	
	@GetMapping("/findByAuthorName/{author}")
	public List<Books> findByAuthorName(@PathVariable String author) {
		return b.findByAuthor(author);
	}
	
	@GetMapping("/searchByCost/{cost}")
	public List<Books> searchByCost(@PathVariable int cost){
		return b.searchByCost(cost);
	}
	
	@GetMapping("/serachById/{id}")
	public Books searchById(@PathVariable int id) {
		return b.searchById(id);
	}
	
	@GetMapping("/lookByAuthor/{author}")
	public List<Books> lookByAuthor(@PathVariable String author){
		return b.lookByAuthor(author);
	}
	
}
