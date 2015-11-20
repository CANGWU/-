
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

import dataservice.DataFactoryService;
import dataserviceimpl.DataFactory;

public class Main {
	//@SuppressWarnings("deprecation")
	public static void main(String[]args){
		//set RMISercurity
	
//		if(System.getSecurityManager() == null){
//			System.setSecurityManager(new RMISecurityManager());	
//		}
//		
		try{
			//LocateRegistry.createRegistry(port); 
			DataFactoryService dataFactory = new DataFactory();
		    //LocateRegistry.createRegistry(1099); 
			Naming.bind("//localhost/getDataFactory",dataFactory);
			System.out.println("OK to bound the RMI Service");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
