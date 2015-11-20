package RMItest;

import java.rmi.Naming;
import dataservice.DataFactoryService;
import dataservice.PManagementDataService;
import pamanagementslservice.PManagementService;
import po.StaffPO;

public class TestMain {
	
	public static void main(String[]args){
		PManagementDataService pamanagementData;
		
		try{
			pamanagementData = (PManagementDataService)Naming.lookup("//localhost:8000/getDataFactory");
			//PManagementDataService pmanagementData = dataFactory.getPManagementData();
			StaffPO po = pamanagementData.find("1");
			System.out.println(po.getName());
			//System.out.println(dataFactory.getPManagementData().find("1").getName());
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
