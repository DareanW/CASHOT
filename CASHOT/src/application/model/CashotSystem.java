package application.model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;



import application.controller.AdminController;
import application.controller.AdminLoginController;
import application.controller.CashierController;
import application.controller.CashierLoginController;
import application.controller.EditItemsController;
import application.controller.MainController;
import application.controller.TrainingController;
import application.controller.TrainingRingUpCustomerController;
import application.controller.addEmployeeFromAdminController;
import application.controller.RingUpCustomerController;

public final class CashotSystem {
	
	private int ID;
	private String admin;
//	private ArrayList<Receipt> receipt;
	public static ArrayList<Employee> employees;
	Item [][] itemMatrix = new Item[6][4];
	
	private Employee signedIn;
	
	private MainController controller;
	private CashierController cController;
	private TrainingController tController;
	private AdminController aController;
	private AdminLoginController aLController;
	private CashierLoginController cLController;
	private addEmployeeFromAdminController aEFAController;
	private RingUpCustomerController ringUpCustomerController;
	private TrainingRingUpCustomerController trainingRingUpCustomerController;

	private EditItemsController EIController;

	
	private final static CashotSystem INSTANCE = new CashotSystem();
	
	public static Order order;
	
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
	public void setController(TrainingRingUpCustomerController controller){
		this.trainingRingUpCustomerController = controller;
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
	

	
	public void newOrder(String mode) {
		
		if (mode.equals("cashier")){
			order = new Order(signedIn);
			signedIn.addOrder(order);			
		}
		if (mode.equals("training")){
			order = new Order();
		}
		
	}
	
	public void ringUp() throws IOException {
		Receipt.printReceipt(order, order.getEmployee());
	}
	
	public void loadEmployees() throws IOException {
		//String employeeName, String userName, String employeePassword, int ID, boolean Admin, 
		String row;
		try{
		BufferedReader csvReader = new BufferedReader( new FileReader("data/employees.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Employee tempEmployee = new Employee(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4],data[5],data[6]);
			addEmployee(tempEmployee);
			
		}
		
		csvReader.close();
		
	}catch(Exception e){
		BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data/employees.csv",false));
		Employee tempEmployee = new Employee("Employee", "employee", "password", Employee.hashNum("employee"), "FALSE", "FALSE", "TRUE");
		csvWriter.write("Employee," + "employee," + "password," + String.valueOf(Employee.hashNum("Employee")) + ",FALSE" + ",FALSE," + "TRUE"+"\n");
		addEmployee(tempEmployee);
		//System.out.println("test");
		tempEmployee = new Employee("Admin", "admin", "admin", Employee.hashNum("Admin"), "TRUE", "FALSE", "FALSE");
		csvWriter.write("Admin," + "admin," + "admin," + String.valueOf(Employee.hashNum("Admin")) + ",TRUE" + ",FALSE," + "FALSE"+"\n");
		addEmployee(tempEmployee);
		csvWriter.close();
	}
		}
	
	public static void addEmployee(Employee employee) {
		employees.add(employee);
	}
	public void removeEmployee(Employee employee){// who let the dogs out
		employees.remove(employee);
	}
	public void updateEmployeeInfo(int id,String actionWanted){// who, who who, who?
		//Iterator i= employees.iterator();
		int count = 0;
		while(employees.size() > count){
			if(id == employees.get(count).getID() && actionWanted.equals("promoteToAdmin")){
				employees.get(count).setAdmin("TRUE");
				employees.get(count).setCashier("FALSE");
				employees.get(count).setTrainiee("FALSE");
			}
			else if(id == employees.get(count).getID() && actionWanted.equals("completeTraining")){
				employees.get(count).setAdmin("FALSE");
				employees.get(count).setCashier("TRUE");
				employees.get(count).setTrainiee("FALSE");
			}
		}
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
		try{
		BufferedReader csvReader = new BufferedReader( new FileReader("data/items.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Item tempItem = new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
			addItem(tempItem);
			
		}
		
		csvReader.close();
		}catch(Exception e){
			  try {

				    Path path = Paths.get("data");

				    //java.nio.file.Files;
				    Files.createDirectories(path);
				  } catch (IOException IO) {
				    System.err.println("Failed to create directory!" + e.getMessage());
				  }
			
			 BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data/items.csv",false));
			 csvWriter.write("");
			 csvWriter.close();
		}
//		cController.hideUnimplementedButtons();
	}
	
	public void addItem(Item item){
		itemMatrix[item.getRow()][item.getColumn()] = item;;
	}
	
	public void removeItem(Item item){
		itemMatrix[item.getRow()][item.getColumn()] = null;;
	}
	
	public void getItemsInButtons(String mode) {
		if (mode.equals("cashier")){
			for (int i = 0; i < 6; i++){
				for (int j = 0; j < 4; j++){
					if (itemMatrix[i][j] != null){
						cController.setButton(itemMatrix[i][j]);
					}
				}
			}
			cController.hideUnimplementedButtons();
		}
		
		else if (mode.equals("admin")){
			for (int i = 0; i < 6; i++){
				for (int j = 0; j < 4; j++){
					if (itemMatrix[i][j] != null){
						aController.setButton(itemMatrix[i][j]);
					}
				}
			}
		}
		
		else if (mode.equals("training")){
			for (int i = 0; i < 6; i++){
				for (int j = 0; j < 4; j++){
					if (itemMatrix[i][j] != null){
						tController.setButton(itemMatrix[i][j]);
					}
				}
			}
			tController.hideUnimplementedButtons();

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
	
	public void logOut(){
		signedIn = null;
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



	public static String callEmployeeMethods(int id,String actionWanted ) throws IOException{//alex added this on friday
		
		if(actionWanted.equals("completeTraining")){
			String temp=Employee.changeEmployeeStat(id,actionWanted);
			if(temp == "FALSE")
				return "FALSE";
			return "TRUE";
		}
		
		if(actionWanted.equals("promoteToAdmin")){
			//System.out.println("entered first promoteToAdmin\n");
			String temp=Employee.changeEmployeeStat(id,actionWanted);
			if(temp == "FALSE")
				return "FALSE";
			return "TRUE";
		}
		
		if(actionWanted.equals("remove")){
			//System.out.println("entered remove if\n");
			String temp=Employee.removeEmployFromFile(id);
			if(temp == "FALSE")
				return "FALSE";
			return "TRUE";
		}
		
		
		
		return "FALSE";
		
	}





	public void setController(RingUpCustomerController ringUpCustomerController) {
		this.ringUpCustomerController = ringUpCustomerController;
		
	}
	
	public ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 4; j++){
				if(itemMatrix[i][j] != null){
					items.add(itemMatrix[i][j]);
				}
			}
		}
		return items;
	}
	
	public boolean searchItems(String itemName) {
		ArrayList<Item> items = new ArrayList<Item>();
		items = getItems();
		for(Item item: items) {
			if (item.getName().equals(itemName)){
				return true;
			}
		}
		
		return false;
		
	}
	
	public Item getSingleItem(String itemName) {
		ArrayList<Item> items = new ArrayList<Item>();
		items = getItems();
		for(Item item: items) {
			if (item.getName().equals(itemName)){
				return item;
			}
		}
		return null;
		
	}
	
	
	public void updateItemsCsv(Item item) throws IOException{
		BufferedReader csvReader = new BufferedReader(new FileReader("data/items.csv"));
		
		StringBuffer buf = new StringBuffer();
		String line;
		
		while((line = csvReader.readLine()) != null){
			buf.append(line);
			buf.append('\n');
		}
		
		String newItemLine = item.getName()+","+item.getPrice()+","+item.getRow()+","+item.getColumn();
		buf.append(newItemLine);
		
		BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data/items.csv",false));
		
		String output = buf.toString();
		csvWriter.write(output);
		
		csvReader.close();
		csvWriter.close();
		
		
	}
	
	public void editItemsCsv(Item item, String name) throws IOException{
		BufferedReader csvReader = new BufferedReader(new FileReader("data/items.csv"));
		
		StringBuffer buf = new StringBuffer();
		String line;
		
		while((line = csvReader.readLine()) != null){
			if(line.contains(name)){
				String newLine = item.getName()+","+item.getPrice()+","+item.getRow()+","+item.getColumn()+"\n";
				buf.append(newLine);
			}else{
				buf.append(line);
				buf.append('\n');
			}
		}
		BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data/items.csv",false));
		
		String output = buf.toString();
		csvWriter.write(output);
		
		csvReader.close();
		csvWriter.close();
		
		
	}

	public void deleteItemCSV(String itemName) throws IOException {
		BufferedReader csvReader = new BufferedReader(new FileReader("data/items.csv"));
		
		StringBuffer buf = new StringBuffer();
		String line;
		
		while((line = csvReader.readLine()) != null){
			if(!line.contains(itemName)){
				buf.append(line);
				buf.append('\n');
			}else{
				// nothing
			}
		}
		
		BufferedWriter csvWriter = new BufferedWriter(new FileWriter("data/items.csv",false));
		
		String output = buf.toString();
		csvWriter.write(output);
		
		csvReader.close();
		csvWriter.close();
		
	}


}