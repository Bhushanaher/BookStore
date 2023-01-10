package com.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BookStore.Service.MyBooklistService;

@Controller
public class MyBookcontroller {

	@Autowired
	MyBooklistService mybookservice;
	
	
	@RequestMapping("/deleteMylist/{id}")
public String deleteMylist(@PathVariable("id")int id) {
		mybookservice.deletebyid(id);
	    return "redirect:/my_book";
}
}
