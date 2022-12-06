package com.epam.library.dto;


public class BookBean {

	int id;
	String name;
	String publisher;
	String author;

	@Override
	public String toString() {
		return "BookBean [id=" + id + ", name=" + name + ", publisher=" + publisher + ", author=" + author + "]";
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
}
