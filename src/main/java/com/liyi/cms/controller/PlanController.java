package com.liyi.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liyi.cms.pojo.Department;
import com.liyi.cms.pojo.Plan;
import com.liyi.cms.service.PlanService;

@Controller
public class PlanController {
	@Autowired
	private PlanService planService;
	
	@RequestMapping("selectPlan")
	public String selectPlan(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "3")Integer pageSize, Plan plan, Model model) {
		PageInfo<Plan> info = planService.selectPlan(page, pageSize, plan);
		model.addAttribute("info", info);
		model.addAttribute("plan", plan);
		return "selectPlan";
	}
	
	//ajax的批量删除
	@ResponseBody
	@RequestMapping("delAll")
	public int deletePlan(@RequestParam("ids") String ids) {
		return planService.deletePlan(ids);
	}
	
	@ResponseBody
	@RequestMapping("selectDepartment")
	public List<Department> selectDepartment() {
		return planService.selectDepartment();
	}
	
	@GetMapping("insertPlan")
	public String insertPlan(Model model, Plan plan) {
		model.addAttribute("plan", plan);
		return "insertPlan";
	}
	
	@ResponseBody
	@PostMapping("insertPlan")
	public int insertPlan(Plan plan) {
		return planService.insert(plan);
	}
	
	@RequestMapping("selectPlanById")
	public String selectPlanById(Model model, Integer id) {
		Plan plan = planService.selectPlanById(id);
		model.addAttribute("plan", plan);
		return "selectPlanById";
	}
	
	@GetMapping("updatePlan")
	public String updatePlan(Model model, Integer id) {
		Plan plan = planService.selectPlanById(id);
		model.addAttribute("plan", plan);
		return "updatePlan";
	}
	
	@PostMapping("updatePlan")
	public String updatePlan(Plan plan) {
		planService.updatePlan(plan);
		return "redirect:selectPlan";
	}
}
