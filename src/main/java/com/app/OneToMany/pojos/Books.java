package com.app.OneToMany.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="book_777")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOKID")
	private Integer bookId;
	
	@Column(name="BOOKNAME")
	private String bookName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="std_id")
	private Student student;
	
	public Books() {
		System.out.println("Books ctor called here"+getClass().getName());
	}

	public Books(Integer bookId, String bookName, Student student) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.student = student;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	

}
