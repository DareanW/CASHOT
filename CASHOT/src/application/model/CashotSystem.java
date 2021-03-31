package application.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import application.controller.CashierController;
import application.controller.MainController;


public class CashotSystem {
	
	private int ID;
//	private ArrayList<Receipt> receipt;
	private static ArrayList<Employee> employees;
	Item [][] itemMatrix = new Item[4][6];
	
	private MainController controller;
	private CashierController cController;
	
	public CashotSystem(){
		employees = new ArrayList<Employee>();
	}
	
	public void setController(MainController controller){
		this.controller = controller;
	}
	
	public void setController(CashierController controller){
		this.cController = controller;
	}
	
	public void loadEmployees() throws IOException {
		//String employeeName, String userName, String employeePassword, int ID
		String row;
		
		BufferedReader csvReader = new BufferedReader( new FileReader("data/employees.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Employee tempEmployee = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]));
			addEmployee(tempEmployee);
			
		}
		
		csvReader.close();
	}
	
	private void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public static String generateEmployeeString(){
		String str = "";
		for (Employee employee: employees){
			str += employee + "\n";
		}
		return str;
	}
	
//	public void loadItems() throws IOException {
//		//String employeeName, String userName, String employeePassword, int ID
//		String row;
//		
//		BufferedReader csvReader = new BufferedReader( new FileReader("data/test.csv") );
//		while ((row = csvReader.readLine()) != null) {
//			String[] data = row.split(",");
//			Item tempItem = new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
//			addItem(tempItem);
//			
//		}
//		
//		csvReader.close();
//	}
	
//	public void addItem(Item item){
//		itemMatrix[item.getRow()][item.getColumn()] = item;
//		cController.setButton(item);
//		System.out.println(itemMatrix[item.getRow()][item.getColumn()]);
////		controller.testMethod();
////		System.out.print(item.getRow());
////		System.out.println(item.getColumn() + " ");
////		System.out.println(itemMatrix[item.getRow()][item.getColumn()]);
//	}
	
}
