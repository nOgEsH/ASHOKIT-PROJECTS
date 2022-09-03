package com.nsh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsh.constants.AppConstants;
import com.nsh.model.Plan;
import com.nsh.props.AppProperties;
import com.nsh.service.PlanService;

@RestController
public class PlanRestController {

	private PlanService planService;
	
	private Map<String, String> messages;

	public PlanRestController(PlanService planService, AppProperties appProp) {
		this.planService = planService;
		this.messages = appProp.getMessages();
	}
	// -----------------------------------------------------------------------------------------------------
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {

		Map<Integer, String> categories = planService.getPlanCategories();

		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	// -----------------------------------------------------------------------------------------------------

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
	
		String responseMsg = AppConstants.EMPTY_STR;
		boolean isSaved = planService.savePlan(plan);
		if (isSaved)
			responseMsg = messages.get(AppConstants.PLAN_SAVE_SUCC);
		else
			responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL);
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}

	// -------------------------------------------------------------------------------------------------------
	@GetMapping("/plan")
	public ResponseEntity<List<Plan>> Plans() {
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}

	// ------------------------------------------------------------------------------------------------------

	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	// ---------------------------------------------------------------------------------------------------

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		String isUpdated = AppConstants.EMPTY_STR;
		boolean updatePlan = planService.updatePlan(plan);
		if (updatePlan) {
			isUpdated = messages.get(AppConstants.PLAN_UPDATE_SUCC);
		} else {
			isUpdated = messages.get(AppConstants.PLAN_UPDATE_FAIL);
		}
		return new ResponseEntity<>(isUpdated, HttpStatus.OK);

	}
	// ---------------------------------------------------------------------------------------------------

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		
		String msg = AppConstants.EMPTY_STR;
		boolean isDeleted = planService.deletePlanById(planId);
		if (isDeleted) {
			msg = messages.get(AppConstants.PLAN_DELETE_SUCC);
		} else {
			msg = messages.get(AppConstants.PLAN_DELETE_FAIL);
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	// ----------------------------------------------------------------------------------------------------

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, String status) {
		
		String msg = AppConstants.EMPTY_STR;
		boolean planStatusChange = planService.planStatusChange(planId, status);
		if (planStatusChange) {
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE);
		} else {
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}