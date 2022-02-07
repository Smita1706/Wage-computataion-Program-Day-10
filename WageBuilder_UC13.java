package com.bridgelabz.WageBuilderDay10;

import java.util.ArrayList;

public class WageBuilder_UC13 implements ComputeWageInterface {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private ArrayList<CompanyEmpWage> arr = new ArrayList<>();

	public void addCompanyEmpWage(String com, int wage, int days,int hrs) {
		CompanyEmpWage company = new  CompanyEmpWage( com, wage,days,hrs);
		arr.add(company);
	}
	
	public void computeEmpWage() {
		int i;
		for(i = 0 ; i < arr.size() ; i++) {
			CompanyEmpWage company = arr.get(i);
			company.setTotalSalary(this.wgeComputeForCompany(company));
			System.out.println(company);
		}
	}
	
	public int wgeComputeForCompany(CompanyEmpWage a) {
		int workingHour = 0;
		int totalWorkingHour = 0;
		int salary = 0;
		int totalSalary = 0;
		int i = 0;
		while(i < a.noOfDays &&  totalWorkingHour <= a.maxHourInMonth) {
			double empCheck = Math.floor(Math.random() * 10) % 3;
			int Check = (int)empCheck;
			switch(Check) {
			case 1:
				workingHour = 8;
				break;
			case 2 :
				workingHour = 4;
				break;
			default : 
				workingHour = 0;
				break;
			}
			i++;
			salary = a.wagePerHour *  workingHour;
			System.out.println("salary is  : " + salary);
			totalSalary += salary; 
			totalWorkingHour +=  workingHour;

		}
		System.out.println("total working hours are  : " + totalWorkingHour);
		return totalSalary;
	}
	void displayTotalSal() {
		
	}
	public static void main(String[] args) {
		ComputeWageInterface a = new WageBuilder_UC13();
		a.addCompanyEmpWage("D-mart", 20, 2, 10);
		a.addCompanyEmpWage("k-mart", 10, 20, 100);
		a.computeEmpWage();		
	}
}
