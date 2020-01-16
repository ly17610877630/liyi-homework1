package com.liyi.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liyi.cms.pojo.Department;
import com.liyi.cms.pojo.Plan;

public interface PlanService {
	PageInfo<Plan> selectPlan(Integer page,Integer pageSize,Plan plan);
	
	List<Department> selectDepartment();
	
	int insert(Plan plan);
	
	int deletePlan(String ids);
	
	Plan selectPlanById(Integer id);
	
	int updatePlan(Plan plan);
	
	public void readTextFile();
}
