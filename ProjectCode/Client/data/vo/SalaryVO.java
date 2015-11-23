package vo;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/26
 * 
 */


import java.io.Serializable;

import enums.Work;

public class SalaryVO implements Serializable{
private double baseWage;
private double allowance;
private double commission;
private Work work;

public SalaryVO(double baseWage, double allowance, double commision,Work work){
this.baseWage = baseWage;
this.allowance = allowance;
this.commission = commision;
this.work=work;
}

public Work getWork() {
	return work;
}

public void setWork(Work work) {
	this.work = work;
}

public SalaryVO(){}

public double getBaseWage() {
	return baseWage;
}

public void setBaseWage(double baseWage) {
	this.baseWage = baseWage;
}

public double getAllowance() {
	return allowance;
}

public void setAllowance(double allowance) {
	this.allowance = allowance;
}

public double getCommission() {
	return commission;
}

public void setCommission(double commission) {
	this.commission = commission;
};



}

