package com.ait.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlanDto {
	
	private Integer planId;
	
	private String planName;
	
	private String comments;
	
	private String activeSwitch;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
}
