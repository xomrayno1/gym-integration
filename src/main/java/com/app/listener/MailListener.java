package com.app.listener;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.MailMessageDTO;
import com.app.dto.VerifyMessageDTO;
import com.app.entity.VerifyOTP;
import com.app.enums.FunctionSendOTP;
import com.app.repository.UserRepository;
import com.app.repository.VerifyOTPRepository;
import com.app.service.EmailService;
import com.app.utils.Commons;
import com.app.utils.EmailTitle;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * lắng nghe các topic về mail
 * 
 * **/
@Component
@Slf4j
@AllArgsConstructor
public class MailListener { 
	
	private final EmailService emailService;
	
	private final VerifyOTPRepository verifyOTPRepo;

	@KafkaListener(id = "regiserVerifyGroup", topics = "MAIL_REGISTER_VERIFY")
	@Transactional(rollbackFor = Exception.class)
	public void registerVerify(VerifyMessageDTO verifyMessageDTO) throws Exception {
		log.info("consumer topic - MAIL_REGISTER_VERIFY receiver {} ", verifyMessageDTO.getEmail());
  
		VerifyOTP verifyOTP = verifyOTPRepo.findByEmailAndFunctionSendOTP(verifyMessageDTO.getEmail(), FunctionSendOTP.REGISTER_VERIFY);
		if(verifyOTP == null) {
			verifyOTP = new VerifyOTP();
		}
		verifyOTP.setEmail(verifyMessageDTO.getEmail());
		verifyOTP.setExpire(LocalDateTime.now().plusSeconds(90));
		final String otp = Commons.randomOTP();
		verifyOTP.setOTP(otp);
		verifyOTP.setFunctionSendOTP(FunctionSendOTP.REGISTER_VERIFY);
		verifyOTPRepo.save(verifyOTP);

		try {
			Map<String, Object> mapParam = new HashMap<>();
			mapParam.put("name", verifyMessageDTO.getName());
			mapParam.put("OTP", otp);
			
			emailService.sendEmail(new MailMessageDTO("tamnct1999@gmail.com", EmailTitle.VERIFY_REGISTER_ACCOUNT, mapParam), "mail-verify-otp");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@KafkaListener(id = "dltGroup", topics = "MAIL_REGISTER_VERIFY.DLT")
	public void registerVerifyDLT(VerifyMessageDTO verifyMessageDTO) throws Exception {
		log.info("consumer topic - MAIL_REGISTER_VERIFY.DLT receiver {} ", verifyMessageDTO.getEmail());
		//save to database to re-send queue
	}
	
	@KafkaListener(id = "mailSendScheduleEveryDay", topics = "MAIL_NOTIFICATION_SCHEDULE_TRAINING_EVERY_DAY")
	@Transactional(rollbackFor = Exception.class)
	public void mailEverySendSchedule(VerifyMessageDTO verifyMessageDTO) throws Exception {
		log.info("consumer topic - MAIL_SEND_SCHEDULE_EVERY_DAY  {} ", verifyMessageDTO.getEmail());
    
		try {
			Map<String, Object> mapParam = new HashMap<>();
			mapParam.put("name", verifyMessageDTO.getName());
			mapParam.put("exercies", Collections.EMPTY_LIST);
			
			emailService.sendEmail(new MailMessageDTO("tamnct1999@gmail.com", EmailTitle.MAIL_NOTIFICATION_SCHEDULE_TRAINING_EVERY_DAY, mapParam), "mail-training-schedule");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
