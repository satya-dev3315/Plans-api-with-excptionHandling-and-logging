package com.ait.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PlansApiExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionInfo> exceptionHandler(Exception e){
		
		ExceptionInfo exceptionInfo = new ExceptionInfo();
		exceptionInfo.setExceptionCode("PLANS-003");
		exceptionInfo.setExceptionMsg(e.getMessage());
		exceptionInfo.setExceptionDate(LocalDateTime.now());
		
		return new ResponseEntity<>(exceptionInfo, HttpStatus.BAD_REQUEST);
		
	}
}
