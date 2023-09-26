package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.VerifyOTP;
import com.app.enums.FunctionSendOTP;

@Repository
public interface VerifyOTPRepository extends CrudRepository<VerifyOTP, Long>{
	
	VerifyOTP findByEmailAndFunctionSendOTP(String email, FunctionSendOTP functionSendOTP);

}
