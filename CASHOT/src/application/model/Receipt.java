package application.model;

import java.io.FileWriter;
import java.io.IOException;
import application.model.Employee;

public class Receipt{

	/*
	public String toString(){
		String receiptTicket = "";
		
		receiptTicket=receiptTicket + Employee.getID();
		
		return receiptTicket;
	}*/
	
	public void printReceipt()throws IOException { //This method will save all current info of the zoo back into the files provided
		
		FileWriter rWriter= new FileWriter("Receipt/" + Order.getCurrTimeDate() + ".csv", false);
	
		for(Order r: Employee.getOrder()){  
		
			rWriter.write(Employee.getID() + " " + Order.getEmployeeName() + " " + r.getItems().toString().replace("[", "").replace("]", "").replace(",", ""));
		
		}
	
		rWriter.flush();
		rWriter.close();
	
}
}
