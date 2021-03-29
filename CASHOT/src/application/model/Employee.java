package application.model;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
private String employeeName;
private String userName;
private String employeePassword;
private static int ID;
private static ArrayList<Order> order;

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
public static ArrayList<Order> getOrder() {
	return order;
}
public void setOrder(ArrayList<Order> order) {
	this.order = order;
}
public static int hashNum(String userName){
	long num = 0;
	for(int i = 0; i < userName.length(); i++)
		num+=userName.codePointAt(i);
	num*=7;
	num*=522;
	num*=3;
    num*=768546547;
	System.out.println(num);
    System.out.println(num % 100000000);
    if(num % 100000000 < 9999999)
    num += 10000000;
	return (int)(num % 100000000);
}

public void add(ArrayList<Employee> employee) {
 
	
}
}
