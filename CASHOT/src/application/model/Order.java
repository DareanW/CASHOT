package application.model;
import java.time.*;
import java.util.*;

public class Order {

	private LocalDateTime currTimeDate;
	private static String employeeName; //changed to static
	private ArrayList<Item> items;
	
	public Order(LocalDateTime currTimeDate,String employeeName){
		
		this.currTimeDate=currTimeDate;
		this.employeeName=employeeName;
		this.items=new ArrayList<Item>();
	}
	
	
	public LocalDateTime getCurrTimeDate() {
		return currTimeDate;
	}
	public void setCurrTimeDate(LocalDateTime currTimeDate) {
		this.currTimeDate = currTimeDate;
	}
	public static String getEmployeeName() { //changed to static
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
