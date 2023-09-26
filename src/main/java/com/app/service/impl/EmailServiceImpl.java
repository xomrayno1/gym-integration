package com.app.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.app.dto.MailMessageDTO;
import com.app.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	SpringTemplateEngine springTemplateEngine;
	
	@Value("${from.mail}")
	private String fromMail;

	@Override
	@Async
	public void sendEmail(MailMessageDTO mailMessageDTO, String template) throws MessagingException {
		log.info("start...send email");
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
		 
		//load template from email
		Context context = getContext(mailMessageDTO.getParams());
		String html = springTemplateEngine.process(template, context);
		
		mimeMessageHelper.setFrom(fromMail);
		mimeMessageHelper.setTo(mailMessageDTO.getTo());
		mimeMessageHelper.setText(html, true);
		mimeMessageHelper.setSubject(mailMessageDTO.getSubject());
		
		javaMailSender.send(mimeMessage);
		
		log.info("end...send email");
	}
	
	public Context getContext(Map<String, Object> mapData) {
		Context context = new Context();
		for(String key: mapData.keySet()) {
			context.setVariable(key,  mapData.get(key));
		}
		return context;
	}

}
