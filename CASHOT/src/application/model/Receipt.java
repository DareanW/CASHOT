package application.model;

public class Receipt {
	
	public String toString(){
		String receiptTicket = "";
		
		receiptTicket=receiptTicket + Order.getEmployeeName() + " " + Employee.getID();
		
		return receiptTicket;
	}
}
