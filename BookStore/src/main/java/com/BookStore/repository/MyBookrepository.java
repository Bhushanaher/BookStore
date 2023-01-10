package com.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStore.Entity.MyBooklist;

@Repository
public interface MyBookrepository extends JpaRepository<MyBooklist, Integer>{

}
