package org.subham.javaworld.Messenger.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private long id;
	private String message;
	private int createdDate;
	private String author;
	private Map<Long, Comments> comments;
	List<Link> links ;
	public Message() {
		super();
	}
	public Message(long id, String message, int createdDate, String author) {
		this.id = id;
		this.message = message;
		this.createdDate = createdDate;
		this.author = author;
		comments = new HashMap<Long, Comments>();
		links = new ArrayList<Link>();
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
	public int getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(int createdDate) {
		this.createdDate = createdDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient
	public Map<Long, Comments> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comments> comments) {
		this.comments = comments;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public void addLink(String url , String rel) {
		Link link = new Link();
		link.setRel(rel);
		link.setUrl(url);
		getLinks().add(link);
	}
}
