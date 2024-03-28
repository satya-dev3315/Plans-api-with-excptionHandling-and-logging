package com.ait.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ait.dto.PlanDto;
import com.ait.entity.Plan;
import com.ait.planRepo.PlanRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlansServiceImpl implements PlansService {

	private final PlanRepo planRepo;
	

	@Override
	public List<PlanDto> retrieveAllPlans() {
		List<Plan> plans = planRepo.findAll();
		List<PlanDto> dtos = new ArrayList<>();           //we have to return data into List<PlanDto>
		
		plans.forEach(e -> {                             //iterate, get each entity obj e and convert to dto obj
			PlanDto dto = new PlanDto();
			BeanUtils.copyProperties(e, dto);
			
			dtos.add(dto);
		});
		return dtos;
	}
	

	@Override
	public boolean savePlan(PlanDto planDto) {
		Plan plan = new Plan();
		BeanUtils.copyProperties(planDto, plan);   //we r passin dto obj, so convert it to entity obj
		plan.setActiveSwitch("Y");                 //by default plan will b in active status
		
		Plan savePlan = planRepo.save(plan);
		if (savePlan.getPlanId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public PlanDto getPlan(Integer planId) {
		Plan plan = planRepo.findById(planId).orElseThrow(() -> new RuntimeException("Plan not found with planId : " + planId));
		PlanDto dto = new PlanDto();
		BeanUtils.copyProperties(plan, dto);
		return dto;
	}

	@Override
	public boolean updatePlan(String status, Integer planId) {
		Plan plan = planRepo.findById(planId).orElseThrow(() -> new RuntimeException("Plan not found with planId : " + planId));
		plan.setActiveSwitch(status);       //whatever status is available, update it in db 
		planRepo.save(plan);
		return true;
	}

}
