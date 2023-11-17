package org.EmailService;

import org.EmailService.Model.EmailDetails;
import org.EmailService.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class EmailServiceApp 
{
	@Autowired
    MailService service;
	@Autowired
	EmailDetails details;
    public static void main( String[] args )
    {
        SpringApplication.run(EmailServiceApp.class, args);
    }
    
    
    
}
