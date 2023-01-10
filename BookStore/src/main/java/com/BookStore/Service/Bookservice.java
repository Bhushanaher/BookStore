package com.BookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.Entity.Book;
import com.BookStore.repository.BookRepository;

@Service
public class Bookservice {
	
	@Autowired
	private BookRepository brepo;
	
	public void save(Book b) {
		brepo.save(b);
	}
	
	public List<Book> getAllbook(){
		return brepo.findAll();
	}
	
	
	public Book getBookbyid(int id) {
		return brepo.findById(id).get();
	}

	
	public void deleteByid(int id) {
		brepo.deleteById(id);
	}
}
