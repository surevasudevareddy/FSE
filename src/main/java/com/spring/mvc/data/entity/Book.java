/**
 * 
 */
package com.spring.mvc.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author 293949
 *
 */
@Entity
@Table(name="book")
public class Book implements Serializable {
	
	public static final long serialVersionUID = 23L;
	
	
	private long bookId;
	private String title;
	private double price;
	private Integer volume;
	@DateTimeFormat(iso=ISO.DATE)
	private Date publishDate;
	
	private Subject subject;

	
	/**
	 * 
	 */
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(long bookId, String titie, double price, Integer volume, Date publishDate, Subject subject) {
		super();
		this.bookId = bookId;
		this.title = titie;
		this.price = price;
		this.volume = volume;
		this.publishDate = publishDate;
		this.subject = subject;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "subjectId")
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", titie=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}
	
}
