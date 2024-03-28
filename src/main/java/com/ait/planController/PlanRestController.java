package com.ait.planController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.PlanDto;
import com.ait.service.PlansService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PlanRestController {
	
	//private static final Logger log = LoggerFactory.getLogger(PlanRestController.class);
	
	private final PlansService plansService;

	@GetMapping("/plans")
	public ResponseEntity<List<PlanDto>> getAllPlans() {
		log.info("getting plans process started");
		List<PlanDto> dto = plansService.retrieveAllPlans();
		log.info("plans retreived successfully");
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@PostMapping("/save")
	public ResponseEntity<String> savePlan(@RequestBody PlanDto planDto) {
		log.info("save plan process started");
		boolean status = plansService.savePlan(planDto);
		if (status) {
			log.info("plan saved successfully");
			return new ResponseEntity<>("Plan is saved", HttpStatus.CREATED);
		}else {
			log.error("Error occured in saving the plan by name {} :",planDto.getPlanName()); //{} is placeholder n planDto.getPlanName() is its value, we can use multiple placeholeders but we need to provide values for each
			return new ResponseEntity<>("Plan is not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/plan/{planId}")
	public ResponseEntity<PlanDto> getPlan(@PathVariable Integer planId) {
		log.info("to get a  plan process started");
		PlanDto dto = plansService.getPlan(planId);
		log.info("plan retreived successfully");
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/update/{planId}/{activeSwitch}")
	public ResponseEntity<String> updatePlan(@PathVariable Integer planId,@PathVariable String activeSwitch) {
		log.info("to update a plan process started");
		boolean status = plansService.updatePlan(activeSwitch, planId);
		if (status) {
			log.info("plan updated successfully");
			return new ResponseEntity<>("Plan is updated", HttpStatus.OK);
		}else {
			log.error("Error occured in updating the plan by name");
			return new ResponseEntity<>("Plan is not updated", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
