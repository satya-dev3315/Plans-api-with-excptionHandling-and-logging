package com.ait.planRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
