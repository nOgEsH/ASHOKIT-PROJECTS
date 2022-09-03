package com.nsh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsh.model.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
