//package com.codingshuttle.project.uber.uberApp;
//
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class UberAppApplicationTests {
//
//	@Autowired
//	private EmailSenderService emailSenderService;
//
//	@Test
//	void contextLoads() {
//		emailSenderService.sendEmail("sariba6063@forcrack.com",
//				"This is a testing email",
//				"this is the body of email");
//	}
//
//	@Test
//	void sendEmailMultiple() {
//		String emails[] = {
//				"sariba6063@forcrack.com",
//				"astha_j@mt.iitr.ac.in",
//				"awani_s@hs.iitr.ac.in",
//				"dj911743@gmail.com"
//		};
//		emailSenderService.sendEmail(emails, "Hello from Astha Jaiswal",
//				"this is a good body, keep going!!");
//	}
//
//}


package com.codingshuttle.project.uber.uberApp;

import com.codingshuttle.project.uber.uberApp.services.EmailSenderService;
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
                "sariba6063@forcrack.com",
                "This is a testing email",
                "this is the body of email"
        );
    }

    @Test
    void sendEmailMultiple() {
        String[] emails = {
                "sariba6063@forcrack.com",
                "astha_j@mt.iitr.ac.in",
                "awani_s@hs.iitr.ac.in",
                "dj911743@gmail.com"
        };
        emailSenderService.sendEmail(emails,
                "Hello from Astha Jaiswal",
                "this is a good body, keep going!!"
        );
    }
}

