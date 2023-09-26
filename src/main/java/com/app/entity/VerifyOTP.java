package com.app.entity;

import java.time.LocalDateTime;

import com.app.enums.FunctionSendOTP;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "verify_otp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyOTP extends BaseEntity{

	private static final long serialVersionUID = -5096185837622422717L;
	
	@Column(name = "otp")
	private String OTP;
	private String email;
	private LocalDateTime expire;
 
	@Enumerated(EnumType.STRING)
	@Column(name = "function_send")
	private FunctionSendOTP functionSendOTP;
	 
	
}
