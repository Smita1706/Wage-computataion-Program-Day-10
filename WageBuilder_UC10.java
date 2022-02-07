package com.bridgelabz.WageBuilderDay10;

public class WageBuilder_UC10 {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private int numOfCompany = 0;
	private  CompanyEmpWage[] arr = new CompanyEmpWage[5];

	private void addCompanyEmpWage(String com, int wage, int days,int hrs) {
		arr[numOfCompany] = new  CompanyEmpWage( com, wage, days, hrs);
		numOfCompany++;
	}
	private void computeEmpWage() {
		int i;
		for(i = 0 ; i < numOfCompany ; i++) {
			arr[i].setTotalSalary(this.wgeComputeForCompany(arr[i]));
			System.out.println(arr[i]);
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
			totalSalary += salary;
			totalWorkingHour +=  workingHour;
		}
		System.out.println("total working hours are  : " + totalWorkingHour);
		return totalSalary;
	}

	public static void main(String[] args) {
		WageBuilder_UC10 a = new WageBuilder_UC10();
		a.addCompanyEmpWage("D-mart", 20, 2, 10);
		a.addCompanyEmpWage("k-mart", 10, 2, 10);
		a.computeEmpWage();		
	}
}
