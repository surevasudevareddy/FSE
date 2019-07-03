package com.spring.mvc.data.service;


import java.util.List;

import com.spring.mvc.data.entity.Book;


public interface BookService extends IOperations<Book> {

	List<Book> findByTitle(String title);
}
