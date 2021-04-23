package application.model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import application.controller.AdminController;
import application.controller.AdminLoginController;
import application.controller.CashierController;
import application.controller.CashierLoginController;
import application.controller.EditItemsController;
import application.controller.MainController;
import application.controller.TrainingController;
import application.controller.ViewDeleteEmployeesController;
import application.controller.addEmployeeFromAdminController;


public final class CashotSystem {
	
	private int ID;
	private String admin;
//	private ArrayList<Receipt> receipt;
	private static ArrayList<Employee> employees;
	Item [][] itemMatrix = new Item[6][4];
	
	private Employee signedIn;
	
	private MainController controller;
	private CashierController cController;
	private TrainingController tController;
	private AdminController aController;
	private AdminLoginController aLController;
	private CashierLoginController cLController;
	private addEmployeeFromAdminController aEFAController;
	private ViewDeleteEmployeesController vdeController;

	private EditItemsController EIController;

	
	private final static CashotSystem INSTANCE = new CashotSystem();
	
	private Order order;
	
	private CashotSystem(){
		employees = new ArrayList<Employee>();
	}
	
	public static CashotSystem getInstance() {
		return INSTANCE;
	}
	
	
	public void setController(MainController controller){
		this.controller = controller;
	}
	public void setController(EditItemsController controller){
		this.EIController = controller;
	}
	public void setController(addEmployeeFromAdminController controller){
		this.aEFAController = controller;
	}
	
	public void setController(CashierController controller){
		this.cController = controller;
	}
	
	public void setController(TrainingController controller){
		this.tController = controller;
	}
	
	public void setController(AdminController controller){
		this.aController = controller;
	}
	
	public void setController(ViewDeleteEmployeesController controller){
		this.vdeController = controller;
	}
	
	public void newOrder() {
		order = new Order(signedIn);
//		System.out.println(order);
//		System.out.println(signedIn);
		signedIn.addOrder(order);
		
	}
	
	public void ringUp() throws IOException {
		Receipt.printReceipt(order, signedIn);
	}
	
	
	public void loadEmployees() throws IOException {
		//String employeeName, String userName, String employeePassword, int ID, boolean Admin, 
		String row;
		
		BufferedReader csvReader = new BufferedReader( new FileReader("data/employees.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Employee tempEmployee = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4],data[5],data[6]);
			addEmployee(tempEmployee);
			
		}
		
		csvReader.close();
	}
	
	public static void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	
	public static ArrayList<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(ArrayList<Employee> employees) {
		CashotSystem.employees = employees;
	}

	public static String generateEmployeeString(){
		String str = "";
		for (Employee employee: employees){
			str += employee + "\n";
		}
		return str;
	}

	public void setController(CashierLoginController cashierLoginController) throws IOException {
		this.cLController = cashierLoginController;
		loadEmployees();
		
	}
	public void setController(AdminLoginController adminLoginController) throws IOException {
		this.aLController = adminLoginController;
		loadEmployees();
	}
	
	public void loadItems() throws IOException {
		//String employeeName, String userName, String employeePassword, int ID
		String row;
		
		BufferedReader csvReader = new BufferedReader( new FileReader("data/test.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Item tempItem = new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
			addItem(tempItem);
			
		}
		
		csvReader.close();
		
//		cController.hideUnimplementedButtons();
	}
	
	public void addItem(Item item){
		itemMatrix[item.getRow()][item.getColumn()] = item;
//		cController.setButton(item);
//		System.out.println(itemMatrix[item.getRow()][item.getColumn()]);
//		controller.testMethod();
//		System.out.print(item.getRow());
//		System.out.println(item.getColumn() + " ");
//		System.out.println(itemMatrix[item.getRow()][item.getColumn()]);
	}
	
	public void getItemsInButtons() {
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 4; j++){
				if (itemMatrix[i][j] != null){
					cController.setButton(itemMatrix[i][j]);
				}
			}
		}
		cController.hideUnimplementedButtons();
	}
	
	public void getItemsInAdminButtons() {
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 4; j++){
				if (itemMatrix[i][j] != null){
					aController.setButton(itemMatrix[i][j]);
				}
			}
		}
	}

	public ArrayList<Item> addItemToOrder(int i, int j) {
		ArrayList<Item> orderItems = order.addItemToOrder(itemMatrix[i][j]);
		return orderItems;
	}
	
	public double getOrderTotal(){
		return order.total();
	}

	
	public void setSignedIn(Employee employee) {
		signedIn = employee;
	}
	
	public Employee getSignedIn(){
		return signedIn;
	}
	
	public static String dblToMoneyString(double price){
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(price);
		return moneyString;
	}
	
public static void newEmployee(Employee employee) throws IOException{
	for(Employee tempEmployee: getEmployees()){
		if(tempEmployee.getUserName().equals(employee))
			return;
	}
	employees.add(employee);
	BufferedWriter writer = new BufferedWriter(new FileWriter("data/employees.csv", true));
	String str = "";
	//writer.write(str);
	//for(Employee employeeList: employees){

	str += employee.getEmployeeName() + "," + employee.getUserName() + "," + employee.getEmployeePassword() + "," + Employee.hashNum(employee.getUserName()) + "," + employee.isAdmin() + "," + employee.getTrainiee() + "," + employee.getCashier() +"\n";

	writer.write(str);
	writer.close();

}
}