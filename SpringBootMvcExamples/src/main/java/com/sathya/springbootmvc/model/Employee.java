package com.sathya.springbootmvc.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Employee {
	
	int empId;
	String empName;
	double empSalary;

	public static void main(String[] args) {
            
		Employee employee=Employee.builder()
				                  .empId(101)
				                  .empName("kusuma")
				                  .empSalary(35000.45)
				                  .build();
		System.out.println(employee);
				
	}

}
