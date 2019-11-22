package com.cybertek.tests.o1_intelijj_navigation;

public class Employee {

	String EmployeeName;
	String EmployeeID;
	int age;
	int SSN;
	String JobTittle;
	double salary;
	
	public Employee(String EmployeeName, String EmployeeID,int age,int SSN,String JobTittle,double salary) {
		
		this.EmployeeName = EmployeeName;
		this.EmployeeID=EmployeeID;
		this.age = age;
		this.SSN=SSN;
		this.JobTittle=JobTittle;
		this.salary=salary;
		
		System.out.println("-----------------------------------------");
	}
	
	public void getInfo() {
		System.out.println("Employee name is: "+EmployeeName);
		System.out.println("Social security number is: "+SSN);
		System.out.println("age is: "+age);
		System.out.println("Job title is: "+ JobTittle);
		System.out.println("Salary: "+ salary);
		
	}
}
