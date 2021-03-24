package application.model;
import java.util.ArrayList;
import java.util.Date;

public class Employee {
private String employeeName;
private String userName;
private String employeePassword;
private int ID;
private ArrayList<Order> order;

public Employee(String employeeName, String userName, String employeePassword, int ID){
	this.employeeName = employeeName;
	this.userName = userName;
	this.employeePassword = employeePassword;
	this.ID = ID;
	this.order = new ArrayList<Order>();
}


public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmployeePassword() {
	return employeePassword;
}
public void setEmployeePassword(String employeePassword) {
	this.employeePassword = employeePassword;
}
public static int getID() {   //changed to static
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public ArrayList<Order> getOrder() {
	return order;
}
public void setOrder(ArrayList<Order> order) {
	this.order = order;
}
}
