package com.ait.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_id")
	private Integer planId;
	
	@Column(name = "plan_name")
	private String planName;
	
	private String comments;
	
	@Column(name = "active_switch")
	private String activeSwitch;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDate updatedDate;
	
	@Column(name = "created_by")
	private String createdBy;     //user name
	
	@Column(name = "updated_by")
	private Integer updatedBy;     //user id

}

