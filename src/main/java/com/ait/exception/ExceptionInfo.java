package com.ait.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionInfo {
 
	private String exceptionCode;
	private String exceptionMsg;
	private LocalDateTime exceptionDate;
}
