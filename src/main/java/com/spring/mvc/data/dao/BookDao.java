package com.spring.mvc.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.mvc.data.entity.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Long>  {
	
	@Query("SELECT b FROM Book b WHERE b.title = :title")
	List<Book> findByTitle(@Param("title") String title);

}
