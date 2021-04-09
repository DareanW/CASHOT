package application.controller;

import java.io.IOException;

import application.model.CashotSystem;
import application.model.Employee;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class addEmployeeFromAdminController {
	@FXML TextField addUsrName;
	@FXML TextField addUsrPw;
	@FXML Button AddEmployee;
	@FXML CheckBox adminStatus;
	@FXML CheckBox trainee;
	@FXML TextField employeeName;
	@FXML private AnchorPane content;
	
	public void addEmployee(Event event) throws IOException {
		String isAdmin = "FALSE";
		if(adminStatus.isSelected())
			isAdmin = "TRUE";
		String newUsername = addUsrName.getText();
		String newEmployeeName = employeeName.getText();
		String newPassword = addUsrPw.getText();
		for(Employee employee: CashotSystem.getEmployees()){
			if(newUsername.equals(employee.getUserName())){
				System.out.println("User exists. Could not add.");
				return;
			}
		}
		//String employeeName, String userName, String employeePassword, int ID, boolean Admin
		Employee newEmployee = new Employee(newEmployeeName, newUsername, newPassword, Employee.hashNum(newUsername), isAdmin);
		CashotSystem.addEmployee(newEmployee);
	}
	public void loadAdminister(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}
	
}
