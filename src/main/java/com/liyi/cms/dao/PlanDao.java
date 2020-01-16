package com.liyi.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liyi.cms.pojo.Department;
import com.liyi.cms.pojo.Plan;

public interface PlanDao {
	List<Plan> selectPlan(Plan plan);
	
	int insertPlan(@Param("list")List<Plan> list);
	
	List<Department> selectDepartment();
	
	int insert(Plan plan);
	
	int deletePlan(@Param("ids")String ids);
	
	Plan selectPlanById(Integer id);
	
	int updatePlan(Plan plan);
}
