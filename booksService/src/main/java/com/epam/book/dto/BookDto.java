package com.epam.book.dto;

public class BookDto {
	
	int id;
	String name;
	String publisher;
	String author;
	
	
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
	@Override
	public String toString() {
		return "BookDto [id=" + id + ", name=" + name + ", publisher=" + publisher + ", author=" + author + "]";
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
