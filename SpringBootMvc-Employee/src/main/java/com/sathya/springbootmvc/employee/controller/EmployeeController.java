package com.sathya.springbootmvc.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.springbootmvc.employee.model.EmployeeModel;
import com.sathya.springbootmvc.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employeeform")
	public String getemployee()
	{
		return "myemployee";
	}
	@PostMapping("/saveemployee")
	public String postemployee(EmployeeModel employeeModel)
	{
       employeeService.saveEmployeeDetilas(employeeModel);
		return "success";
	}
}
