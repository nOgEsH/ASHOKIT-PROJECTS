package com.nsh.service;

import java.util.List;
import java.util.Map;

import com.nsh.model.Plan;

public interface PlanService {

	
	public Map<Integer,String> getPlanCategories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getAllPlans();
	
	public Plan getPlanById(Integer id);
	
	public boolean updatePlan(Plan plan);
	
	public boolean deletePlanById(Integer planId);

	public boolean planStatusChange(Integer planId, String activeSw);
}

