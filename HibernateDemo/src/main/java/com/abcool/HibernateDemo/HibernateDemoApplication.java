package com.abcool.HibernateDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.abcool.Models.Books;
import com.abcool.Repository.BookRepository;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Autowired
	BookRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Books b1 = new Books();
		b1.setId(1);
		b1.setName("Abcool");
		b1.setAuthorName("Arvind");
		b1.setCost(100000);
		repo.save(b1);
	}

}
