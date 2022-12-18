package org.subham.javaworld.Messenger.Entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comments {
	long id;
	String message;
	int dateCreated;
	String author;
	
	public Comments() {}
	public Comments(long id, String message, int dateCreated, String author) {
		this.id = id;
		this.message = message;
		this.dateCreated = dateCreated;
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(int dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
