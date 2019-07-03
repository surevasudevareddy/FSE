package com.spring.mvc.data.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.data.dao.BookDao;
import com.spring.mvc.data.entity.Book;


@Service
@Transactional
@Component("BookService")
public class BookServiceImpl extends AbstractService<Book> implements BookService {
	@Autowired
	private BookDao dao;
	
	
	public BookServiceImpl() {
		super();
	}
	
	@Override
    protected BookDao getDao() {
        return  dao;
    }
	
	// custom methods

    @Override
    public List<Book> findByTitle(String title) {
        return getDao().findByTitle(title);
    }

}
