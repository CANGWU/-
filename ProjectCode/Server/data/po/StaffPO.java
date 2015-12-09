package po;

import java.io.Serializable;

import enums.Sex;
import enums.Work;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/22
 *
 */

public class StaffPO implements Serializable{
String name; 
Work work;
String workNumber;
String workPlaceNumber;
String birthDate;
String idNumber;
String phoneNumber;
String address;
Sex sex;
double page;

public StaffPO(String name,Work work,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,Sex sex,double page){
this.name = name;
this.work = work;
this.workNumber = workNumber;
this.workPlaceNumber = workPlaceNumber;
this.birthDate = birthDate;
this.idNumber = idNumber;
this.phoneNumber = phoneNumber;
this.address = address;
this.sex = sex;
this.page = page;
}

public StaffPO(){};

public String getPhoneNumber(){
	    return phoneNumber;
}

public String getName(){
return name;
}

public Work getWork(){
	return work;
}

public String getWorkNumber(){
return workNumber;
}

public String getWorkPlaceNumber(){
	return workPlaceNumber;	
}

public String getBrithDate(){
	return birthDate;
}

public String getIDNumber(){
	return idNumber;
}

public String getAddress(){
	return address;
}

public Sex getSex(){
	return sex;
}

public double getPage(){
	return page;
}

public void setName(String name){
	this.name = name;
}

public void setWorkNumber(String workNumber){
	this.workNumber = workNumber;
}

public void setWorkPlaceNumber(String workPlaceNumber){
	this.workPlaceNumber =workPlaceNumber;
}

public void setIDNumber(String idNumber){
	this.idNumber = idNumber;
}

public void setBrithDate(String birthDate){
	this.birthDate = birthDate;
}

public void setAddress(String address){
	this.address = address;
}

public void setPage(double page){
	this.page = page;
}

public void setWork(Work work){
	this.work = work;
}

public void setSex(Sex sex){
	this.sex = sex;
}

public void setPhoneNumber(String phoneNumber){
	this.phoneNumber = phoneNumber;
}
}