package application.controller;

import java.io.IOException;

import application.model.CashotSystem;

import application.model.Item;
import application.model.Employee;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements EventHandler {
	CashotSystem system = CashotSystem.getInstance();

	
	@FXML Button cBtn;
	
	public void initialize( ) throws IOException{
		//Load items ?
		system.setController(this);
		
		system.loadItems();
		system.loadEmployees();
		
		
		// REMOVE THIS LATER. I'M LAZY AND TIRED OF SIGNING IN EVERY TIME
		for(Employee employee: system.getEmployees()){
			//System.out.println("test2");
			if(employee.getUserName().equals("admin") && employee.getEmployeePassword().equals("admin") && employee.isAdmin().equals("TRUE")){
				system.setSignedIn(employee);
				break;
			}
		}
		
	}
	

	@FXML private AnchorPane content;
	@FXML private TextArea adminTextArea;
	@FXML private Button btnLogin;
	//For admin login screen
	@FXML private TextField adminUsrName;
	@FXML private TextField adminUsrPw;
	//For Employee login screen
	@FXML private TextField employeeUsrName;
	@FXML private TextField employeeUsrPw;
	//For Employees
	@FXML private TextField inputField;
	@FXML private TextArea outputField;

	@Override

	public void handle(Event event) {


	}
	
	public void loadCashier(Event event) throws IOException {
		try {
			if (system.getSignedIn().isAdmin().equals("TRUE") || system.getSignedIn().getCashier().equals("TRUE")){
				bypassEmployeeLogin(event);
			}
			else {
				loadEmployeeLogin(event);
			}
		} catch(Exception e) {
			loadEmployeeLogin(event);
		}
	}
	
	public void loadEmployeeLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/employeeLoginScreen.fxml"));
		content.getChildren().setAll(pane);
	}

	public void bypassEmployeeLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/cashier.fxml"));
		content.getChildren().setAll(pane);		
	}
	
	public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadAdminister(Event event) throws IOException {
		try {
			if (system.getSignedIn().isAdmin().equals("TRUE")){
				bypassAdminLogin(event);
			}
			else {
				loadAdminLogin(event);
			}
		} catch(Exception e) {
			loadAdminLogin(event);
		}
	}
	
	public void bypassAdminLogin (Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadAdminLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/adminLoginScreen.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadTraining(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/Training.fxml"));
		content.getChildren().setAll(pane);
	}	
	
	
	
	
//	public void addEmployeeFromAdmin(Event event) throws IOException{
//		int ID = 
//		String userName = inputField.getText();
//		Employee newEmployee = new Employee(, data[1], data[2], Integer.parseInt(data[3]), data[4]);
//		CashotSystem.addEmployee(newEmployee);
//	}
	
	public void viewEmployees(Event event) {
		String str = CashotSystem.generateEmployeeString();
		adminTextArea.setText(str);
	}	
	

}



