package org.EmailService.Model;

import org.springframework.stereotype.Component;

@Component
public class EmailDetails {

	private String recipent;
	private String subject;
	private String emailBody;
	
	public String getRecipent() {
		return recipent;
	}
	public void setRecipent(String recipent) {
		this.recipent = recipent;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	
	
	
	
	
	
}
