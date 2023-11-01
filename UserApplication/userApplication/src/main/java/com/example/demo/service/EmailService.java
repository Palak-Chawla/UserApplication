package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailService {
	private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;
    
    JavaMailSenderImpl sesSender = new JavaMailSenderImpl();

    @Autowired
    public EmailService(JavaMailSender emailSender, SpringTemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    public void sendMail(String to, String subject, String template, Context context) throws MessagingException {
        MimeMessage mimeMessage = sesSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);

        String htmlContent = templateEngine.process(template, context);
        helper.setText(htmlContent, true);

        emailSender.send(mimeMessage);
    }
	
}
