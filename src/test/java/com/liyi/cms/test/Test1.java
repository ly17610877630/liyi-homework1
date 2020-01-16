package com.liyi.cms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liyi.cms.service.PlanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class Test1 {
	
	@Autowired
	private PlanService planService;
	
	@Test
	public void test() {
		planService.readTextFile();
	}
}
