package com.epam.book.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Library;

@Entity
@Table(name = "book")
public class BookEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String publisher;
	String author;
	
	
	public BookEntity()
	{
		
	}
	
	
	public BookEntity(String name, String publisher, String author) {
		this.name = name;
		this.publisher = publisher;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", publisher=" + publisher + ", author=" + author + "]";
	}
	

}
