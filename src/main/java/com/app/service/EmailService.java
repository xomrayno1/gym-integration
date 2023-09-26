package com.app.service;

import com.app.dto.MailMessageDTO;

import jakarta.mail.MessagingException;

public interface EmailService {
	public void sendEmail(MailMessageDTO mailMessageDTO, String template) throws MessagingException;
}
