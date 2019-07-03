package com.spring.mvc.data.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="subject")
public class Subject  implements Serializable{
	
	public static final long serialVersionUID = 13L;
	
	private long subjectId;
	private String subTitle;
	private int durationInHours;
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Book.class)
   // @JoinTable(name = "Book", joinColumns = { @JoinColumn(name = "subjectId") }, inverseJoinColumns = { @JoinColumn(name = "bookId") })
	 //@OneToMany(mappedBy = "subject", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@OrderBy("name ASC")
	//@Transient
	private Set<Book> references = new HashSet<Book>(0);

	
	public Subject() {
	}

	public Subject(long _subjectId, String _subtitle, int _durationInHrs) {
		this.subjectId = _subjectId;
		this.subTitle = _subtitle;
		this.durationInHours = _durationInHrs;
		
	}

	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	@OneToMany(mappedBy = "subject", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Book> getReferences() {
		return references;
	}

	public void setReferences(Set<Book> references) {
		this.references = references;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subTitle + ", durationInHrs=" + durationInHours
				+ ", references=" + references + "]";
	}
}
