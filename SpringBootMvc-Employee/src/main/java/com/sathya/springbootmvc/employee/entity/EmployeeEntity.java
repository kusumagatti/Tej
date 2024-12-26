package com.sathya.springbootmvc.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 
@Entity
public class EmployeeEntity {

	private int employeeId;
	private String empName;
	private double empSalary;
	private String department;
	private long phoneNumber;
	private double bonusSalary;
    private double netSalary;
    private double grosSalary;
    private double pf;
    private double hra;
	

}
