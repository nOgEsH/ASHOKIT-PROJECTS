package com.nsh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsh.model.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
