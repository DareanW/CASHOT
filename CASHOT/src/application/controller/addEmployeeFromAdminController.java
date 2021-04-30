package application.controller;

/**
 * addEmployeFromAdminController will give admin access to add more employees to the register 
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 */
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
	@FXML
	TextField addUsrName;
	@FXML
	TextField addUsrPw;
	@FXML
	Button AddEmployee;
	@FXML
	CheckBox adminStatus;
	@FXML
	CheckBox trainee;
	@FXML
	TextField employeeName;
	@FXML
	private AnchorPane content;

	/**
	 * addEmployee method will add an employee object to the arraylist
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void addEmployee(Event event) throws IOException {
		String isAdmin = "FALSE";
		if (adminStatus.isSelected())
			isAdmin = "TRUE";
		String newUsername = addUsrName.getText();
		String newEmployeeName = employeeName.getText();
		String newPassword = addUsrPw.getText();
		String newTrainee, newCashier;
		if ((!adminStatus.isSelected()) && trainee.isSelected()) {
			newTrainee = "TRUE";
			newCashier = "FALSE";
		} else if ((!adminStatus.isSelected()) && (!trainee.isSelected())) {
			newTrainee = "FALSE";
			newCashier = "TRUE";
		} else {
			newTrainee = "FALSE";
			newCashier = "FALSE";
		}
		for (Employee employee : CashotSystem.getEmployees()) {
			if (newUsername.equals(employee.getUserName())) {
				System.out.println("User exists. Could not add.");
				return;
			}
		}
		// String employeeName, String userName, String employeePassword, int
		// ID, boolean Admin, String Trainee
		Employee newEmployee = new Employee(newEmployeeName, newUsername, newPassword, Employee.hashNum(newUsername),
				isAdmin, newTrainee, newCashier);
		CashotSystem.newEmployee(newEmployee);
	}

	/**
	 * will launch the admin view
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void loadAdminister(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}

}
