package application.model;
import java.time.*;
import java.util.*;

public class Order {
 
	private static LocalDateTime currTimeDate; //changed to static
	private static String employeeName; //changed to static
	private ArrayList<Item> items;
	private double total;
	private int id;
	private static Employee employee;
	
	public Order(LocalDateTime currTimeDate,String employeeName){
		
		this.currTimeDate=currTimeDate;
		this.employeeName=employeeName;
		this.items=new ArrayList<Item>();
//		this.total = total;
	}
	
	public Order(Employee employee){ //constructor test to get cashier to add stuff
		
		this.currTimeDate= LocalDateTime.now();
		this.employeeName= "" ;
		this.items=new ArrayList<Item>();
		this.total = 0;
		this.employee = employee;
	}
	
	public String toString(){
		String temp = "";
		
		temp = temp + currTimeDate + " " + employeeName + " " + total;
		
		
		for(int i=0;i<items.size(); i++) 
		{
			temp = temp + items.get(i);											
		}
	
		return temp;
	}
	
	public Employee getEmployee(){
		return this.employee;
	}
	
	public double total(){
		double cost = 0.00;
		
		for(Item item : items){
			cost += item.itemPrice;
		}
		
		return cost;
	}
	
	public double getTotal() {
		return total();
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	public ArrayList<Item> addItemToOrder(Item item){
		items.add(item);
		return items;
	}


	public static LocalDateTime getCurrTimeDate() {  //changed to static
		return currTimeDate;
	}
	public void setCurrTimeDate(LocalDateTime currTimeDate) {
		this.currTimeDate = currTimeDate;
	}
	public static String getEmployeeName() { //changed to static
		return employee.getEmployeeName();
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
	
}
