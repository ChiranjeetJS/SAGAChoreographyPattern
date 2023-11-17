package org.EmailService.Controller;

import org.EmailService.Service.MailService;
import org.EmailService.Model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EmailService")
public class EmailController {
	
	@Autowired
	MailService service;
	
	@Value("${message}")
    String msg;
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody EmailDetails details) {
		
		return service.sendMail(details);
		
	}
	
	@GetMapping("/status")
	public String msg() {
		return msg;
	}

}
