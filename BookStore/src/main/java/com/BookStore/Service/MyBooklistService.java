package com.BookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.Entity.MyBooklist;
import com.BookStore.repository.MyBookrepository;

@Service
public class MyBooklistService {

	@Autowired
	private MyBookrepository Mybook;
	
	public void saveMyBooks(MyBooklist Book) {
		Mybook.save(Book);
		
	}
	
	public List<MyBooklist> getAllmybooks() {
		return Mybook.findAll();
		
	}
	
	public void deletebyid(int id) {
		Mybook.deleteById(id);
		
		
	}
}
