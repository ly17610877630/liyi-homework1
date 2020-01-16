package com.liyi.cms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liyi.cms.dao.PlanDao;
import com.liyi.cms.pojo.Department;
import com.liyi.cms.pojo.Plan;
import com.liyi.maven.common_utils.FileUtil;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanDao planDao;
	
	@Override
	public PageInfo<Plan> selectPlan(Integer page, Integer pageSize, Plan plan) {
		PageHelper.startPage(page, pageSize);
		List<Plan> list = planDao.selectPlan(plan);
		return new PageInfo<Plan>(list);
	}

	@Override
	public List<Department> selectDepartment() {
		return planDao.selectDepartment();
	}
	
	@Override
	public int insert(Plan plan) {
		return planDao.insert(plan);
	}	

	@Override
	public int deletePlan(String ids) {
		return planDao.deletePlan(ids);
	}
	
	@Override
	public Plan selectPlanById(Integer id) {
		return planDao.selectPlanById(id);
	}

	@Override
	public int updatePlan(Plan plan) {
		return planDao.updatePlan(plan);
	}

	@Override
	public void readTextFile() {
		ArrayList<Plan> list2 = new ArrayList<Plan>();
		List<String> list = FileUtil.readTextFileToList("D:\\workspace\\CMS_Workspace\\homework1\\src\\test\\resources\\nengyuan.txt");
		for (String string : list) {
			String[] split = string.split("\\|\\|");
			Plan p = new Plan();
			p.setName(split[0]);
			p.setAmout(split[1]);
			p.setManger(split[2]);
			p.setContent(split[3]);
			if(split[4].equals("炸药厂")) {
				p.setDid(1);
			}else if(split[4].equals("生产服务中心")) {
				p.setDid(2);
			}if(split[4].equals("洗选车间")) {
				p.setDid(3);
			}if(split[4].equals("矸电公司")) {
				p.setDid(4);
			}if(split[4].equals("大准铁路公司")) {
				p.setDid(5);
			}if(split[4].equals("准能选煤厂")) {
				p.setDid(6);
			}
			list2.add(p);
		}
		planDao.insertPlan(list2);
	}
}
