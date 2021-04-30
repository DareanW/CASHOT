package application.model;

import java.time.*;
import java.util.*;

/**
 * The Order class holds the information for price totals, the employee, date,
 * time, and IDs
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */
public class Order {

	private static LocalDateTime currTimeDate; // changed to static
	private static String employeeName; // changed to static
	private ArrayList<Item> items;
	private double total;
	private int id;
	private static Employee employee;

	/**
	 * Order constructor for the order
	 * 
	 * @param currTimeDate
	 * @param employeeName
	 */
	public Order(LocalDateTime currTimeDate, String employeeName) {

		Order.currTimeDate = currTimeDate;
		Order.employeeName = employeeName;
		this.items = new ArrayList<Item>();
		// this.total = total;
	}

	/**
	 * Order constructor to test cashier
	 * 
	 * @param employee
	 */
	public Order(Employee employee) { // constructor test to get cashier to add
										// stuff

		Order.currTimeDate = LocalDateTime.now();
		Order.employeeName = "";
		this.items = new ArrayList<Item>();
		this.total = 0;
		Order.employee = employee;
	}

	/**
	 * Order default constructor
	 */
	public Order() {
		Order.currTimeDate = LocalDateTime.now();
		Order.employeeName = "";
		this.items = new ArrayList<Item>();
		this.total = 0;
	}

	/**
	 * toString for the order class
	 */
	@Override
	public String toString() {
		String temp = "";

		temp = temp + currTimeDate + " " + employeeName + " " + total;

		for (int i = 0; i < items.size(); i++) {
			temp = temp + items.get(i);
		}

		return temp;
	}

	/**
	 * getEmployee returns the order of the employee
	 * 
	 * @return employee
	 */
	public Employee getEmployee() {
		return Order.employee;
	}

	/**
	 * total method to get the cost of item/s
	 * 
	 * @return cost
	 */
	public double total() {
		double cost = 0.00;

		for (Item item : items) {
			cost += item.itemPrice;
		}

		return cost;
	}

	/**
	 * getTotal returns the total of the item costs
	 * 
	 * @return total
	 */
	public double getTotal() {
		return total();
	}

	/**
	 * setTotal sets the total of the items
	 * 
	 * @param total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * addItemToOrder method adds items to an ArrayList
	 * 
	 * @param item
	 * @return
	 */
	public ArrayList<Item> addItemToOrder(Item item) {
		items.add(item);
		return items;
	}

	/**
	 * getCurrTimeDate returns the current time and date
	 * 
	 * @return currTimeDate
	 */
	public static LocalDateTime getCurrTimeDate() { // changed to static
		return currTimeDate;
	}

	/**
	 * setCurrTimeDate sets the current time and date
	 * 
	 * @param currTimeDate
	 */
	public void setCurrTimeDate(LocalDateTime currTimeDate) {
		Order.currTimeDate = currTimeDate;
	}

	/**
	 * getEmployeeName returns the employee name
	 * 
	 * @return getEmployeeName
	 */
	public static String getEmployeeName() { // changed to static
		return employee.getEmployeeName();
	}

	/**
	 * setEmployeeName sets the employee name
	 * 
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		Order.employeeName = employeeName;
	}

	/**
	 * getItems returns the item/s
	 * 
	 * @return items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * setItems set the items in the ArrayList
	 * 
	 * @param items
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
