package org.subham.javaworld.Messenger.Entity;

public class ErrorMessage {
	String errorMessage;
	int errorCode;
	String link;
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(String errorMessage, int errorCode, String link) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.link = link;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
