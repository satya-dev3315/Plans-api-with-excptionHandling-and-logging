package com.ait.service;

import java.util.List;

import com.ait.dto.PlanDto;

public interface PlansService {
	
	public List<PlanDto> retrieveAllPlans();
	
	public boolean savePlan(PlanDto planDto);
	
	public PlanDto getPlan(Integer planId);    //used to edit the plans.When we click on edit, display plan data in editable mode.ie: Get plan by id and then edit it
		
	public boolean updatePlan(String status,Integer planId);  //its to activate or deactivate plan,ie: kind of soft delete 
}
