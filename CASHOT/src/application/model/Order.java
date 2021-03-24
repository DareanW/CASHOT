package application.model;
import java.time.*;
import java.util.*;

public class Order {

	private LocalDateTime currTimeDate;
	private String employeeName;
	private ArrayList<Item> items;
	private double total;
	
	public Order(LocalDateTime currTimeDate,String employeeName){
		
		this.currTimeDate=currTimeDate;
		this.employeeName=employeeName;
		this.items=new ArrayList<Item>();
		this.total = total();
	}
	
	
	public double total(){
		double cost = 0.00;
		
		for(Item item : items){
			cost += item.itemPrice;
		}
		
		return cost;
	}
	
	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public LocalDateTime getCurrTimeDate() {
		return currTimeDate;
	}
	public void setCurrTimeDate(LocalDateTime currTimeDate) {
		this.currTimeDate = currTimeDate;
	}
	public String getEmployeeName() {
		return employeeName;
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
