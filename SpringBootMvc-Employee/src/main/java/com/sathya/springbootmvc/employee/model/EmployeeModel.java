package com.sathya.springbootmvc.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeModel {
 
	private int empId;
	private String empName;
	private double empSalary;
	private  String department;
	private long phoneNumber;
	private double bonusSalary;
	
}
