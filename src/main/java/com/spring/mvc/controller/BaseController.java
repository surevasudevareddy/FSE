package com.spring.mvc.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.data.entity.Book;
import com.spring.mvc.data.entity.Subject;
import com.spring.mvc.data.service.BookService;
import com.spring.mvc.data.service.SubjectService;


@Controller
public class BaseController {
	
	@Autowired
	SubjectService ss;
	@Autowired
	BookService bs;
	
	public BaseController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String home( Model model) {
		System.out.println("Home Page Requested, locale = " );
		Locale locale = new Locale("EN-US");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	@GetMapping("/addSubject")
	public String addNewSubject(Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName","Please enter Subject details");
		return "addSubject";
	}
	@RequestMapping(value = "/subject", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute("subject") Subject subject, BindingResult result,Model model) throws Exception {
		System.out.println("Adding new Subject" + subject);
		System.out.println("any error :"+result.getAllErrors());
		ss.create(subject);
		model.addAttribute("userName","Book Details have been added under given SUbject Id");
		return "addSubject";
	}
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, BindingResult result, Model model) throws Exception {
		System.out.println("Adding new Book" + book );
		System.out.println("Adding new Subject" + book.getSubject() );
		if(book.getSubject().getSubjectId() > 0){
			//com.hibernate.vo.Subject subject = new com.hibernate.vo.Subject();
			//subject.setSubjectId(subjectId);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			//Date date = simpleDateFormat.parse(book.getPublishDate());
			//com.hibernate.vo.Book book1 = new com.hibernate.vo.Book(0,book.getTitle(),book.getPrice(),book.getVolume(),date,subject);
			bs.create(book);
		}
		model.addAttribute("userName","Book Details have been added under given Subject Id");
		return "addBook";
	}
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addNewBook(Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName","Please enter Book details");
		return "addBook";
	}@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String deleteBook( Model model) throws SQLException {
		System.out.println("User Page Requested");
		model.addAttribute("userName", "Please enter Book id, which one you want to delete");
		
		return "deleteBook";
	}
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(@Validated Book book, Model model) throws SQLException {
		System.out.println("User Page Requested");
		if(book.getBookId() > 0){
		bs.delete(book);
		model.addAttribute("books", "The specified Book got delted:");
		}
		return "deleteBook";
	}
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.GET)
	public String deleteSubject(Model model) {
		System.out.println("User Page Requested for Delete Subject");
		model.addAttribute("userName", "Please enter Subject id, which one you want to delete");
		
		return "deleteSubject";
	}
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.POST)
	public String deleteSubject(@Validated Subject subject, Model model) throws SQLException {
		System.out.println("User Page Requested for Delete Subject");
		model.addAttribute("userName", "Please enter Subject id, which one you want to delete");
		if(subject.getSubjectId() > 0){
			ss.delete(subject);
			model.addAttribute("subjects", ss.findAll());
		}
		return "deleteSubject";
	}
	@RequestMapping(value = "/searchBook", method = RequestMethod.GET)
	public String searchBook(Model model) {
		System.out.println("User Page Requested" );
		
		return "searchBook";
	}
	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public String searchBook(@Validated Book book,Model model) throws SQLException {
		System.out.println("User Page Requested Search Books:" +book);
		if(book.getBookId() != 0){
			List<Book> books = new ArrayList<Book>();
			books.add(bs.findOne(book.getBookId()));
			model.addAttribute("books", books);
			
		}else if(book.getTitle() != null){
			model.addAttribute("books", bs.findByTitle(book.getTitle()));
		}else{
			model.addAttribute("books", bs.findAll());
		}
		return "searchBook";
	}
	@RequestMapping(value = "/searchSubject", method = RequestMethod.GET)
	public String searchSubject(Model model) {
		System.out.println("User Page  Requested" );
		
		return "searchSubject";
	}
	@RequestMapping(value = "/searchSubject", method = RequestMethod.POST)
	public String searchSubject1(@Validated Subject subject, Model model) throws SQLException {
		System.out.println("User Page Requested" +subject);
		if(subject.getSubjectId() != 0){
			List<Subject> subjects = new ArrayList<Subject>();
			subjects.add(ss.findOne(subject.getSubjectId()));
			model.addAttribute("subjects", subjects);
		}else if(subject.getDurationInHours()!= 0){
			List<Subject> subjects = new ArrayList<Subject>();
			subjects.addAll(ss.findByDuration(subject.getDurationInHours()));
			model.addAttribute("subjects", subjects);
		}else{
			model.addAttribute("subjects", ss.findAll());
		}
		return "searchSubject";
	}
}
