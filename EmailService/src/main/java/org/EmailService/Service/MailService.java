package org.EmailService.Service;

import java.io.InputStream;

import org.BaseDomain.Model.OrderEvent;
import org.EmailService.Model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	 JavaMailSenderImpl mailsender;
	
	public String sendMail(EmailDetails details) {
	
		
	
		
		SimpleMailMessage mailmessage = new SimpleMailMessage();
		
	   try {
		   mailmessage.setTo(details.getRecipent());
		   mailmessage.setSubject(details.getSubject());
		   mailmessage.setFrom("springbootmail20@gmail.com");
		   mailmessage.setText(details.getEmailBody());
		   
		   mailsender.send(mailmessage);
		   
		   return "Mail sent successfully";
		   
		   
	   }
	   catch (Exception ex) {
		   ex.printStackTrace();
		   return "Mail  cannot be sent successfully";
	   }
	   

	}

	public void processEmail(OrderEvent order) {
		// TODO Auto-generated method stub
		
	//	generateTable(order);
		SimpleMailMessage mailmessage = new SimpleMailMessage();
		
		String subject = " Order "+order.getOrderStatus()+" Notification";
		String status = "";
		if(order.getOrderStatus().equals("Failure")) {
			status = "failed";
		}
		else if(order.getOrderStatus().equals("Success")) {
			status = "been confirmed";
		}
		String Body = "Hi "+order.getUserId()+",\n\n"+" Your order of "+order.getProductName()+" OrderId "+order.getOrderId()+" has "+status+".\n"+" Please note the transactionId "+order.getTxnID()+" for any queries."+"\n\n"+"Order Details\n"
				+ "\n transaction ID  "+order.getTxnID()+"\n ProductName "+order.getProductName()+"\nCost "+order.getTotalcost()+"\n OrderStatus "+order.getOrderStatus()+"\n User Id "+order.getUserId()+"\n\nThank you!";
		
		try {
			mailmessage.setTo(order.getEmailId());
			mailmessage.setSubject(subject);
			mailmessage.setText(Body);
			mailmessage.setFrom("springbootmail20@gmail.com");
			mailsender.send(mailmessage);
		
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	private void generateTable(OrderEvent order) {
		// TODO Auto-generated method stub
		
		
		
	}
	


}
