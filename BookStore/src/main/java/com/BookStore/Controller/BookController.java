package com.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BookStore.Entity.Book;
import com.BookStore.Entity.MyBooklist;
import com.BookStore.Service.Bookservice;
import com.BookStore.Service.MyBooklistService;


@Controller
public class BookController {
	@Autowired
	Bookservice Bservice;
	
	
	
	@Autowired
	private MyBooklistService listservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_book")
	public ModelAndView getAllbooks() {
		List<Book> list=Bservice.getAllbook();
		ModelAndView m=new ModelAndView();
		m.setViewName("booklist");
		m.addObject("book", list);
		return m;
	}
	
	
	@PostMapping("/save")
	public String addbook(@ModelAttribute Book b) {
		Bservice.save(b);
		return "redirect:/available_book";
		
	}
	
	@GetMapping("/my_book")
	public String mybook(Model mobel) {
		List<MyBooklist>list=listservice.getAllmybooks();
		mobel.addAttribute("book",list);
		return "myBook";
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String  getMylist(@PathVariable("id") int id) {
		Book B=Bservice.getBookbyid(id);
		MyBooklist mb=new MyBooklist(B.getId(),B.getName(),B.getAuthor(),B.getPrice());
		listservice.saveMyBooks(mb);
		return "redirect:/my_book"	;	
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id,Model model) {
		Book b=Bservice.getBookbyid(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		Bservice.deleteByid(id);
		return "redirect:/available_book";
		
	}
}
