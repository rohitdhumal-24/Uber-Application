package com.rohit.project.uber.uberApp;

import com.rohit.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail(
				"davade1434@chysir.com",
				"This is testing Email",
				"Body of Email"
		);
	}

	@Test
	void sendEmailMultiple(){
		String emails[] = {
				"davade1434@chysir.com",
				"rd989563@gmail.com"
		};
		emailSenderService.sendEmail(emails,
				"Hello from Demo UBER Application Rohit,",
				"this is The Demo Massage from Rohits Application Body keep Goning ");
	}

}
// Tempmail is used to Generate the Fresh Email