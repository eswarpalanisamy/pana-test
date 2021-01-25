package com.apple.resources;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldBean {

	private String message;
	private String messageBy;
	
	@Autowired
	private Contact objContact;

	public Contact getObjContact() {
		return objContact;
	}

	public void setObjContact(Contact objContact) {
		this.objContact = objContact;
	}

	public String getMessage() {
		return message;
	}

	public String getMessageBy() {
		return messageBy;
	}

	public void setMessageBy(String messageBy) {
		this.messageBy = messageBy;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message, String messageBy) {
		this.message = message;
		this.messageBy=messageBy;
	}

}
