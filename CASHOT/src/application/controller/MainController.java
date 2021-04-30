package application.controller;

import java.io.IOException;

import application.model.CashotSystem;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

/**
 * The MainController is the first page that the user will see. This will ask
 * them if they want to log into Admin, Cashier or Trainee mode.
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */
public class MainController implements EventHandler {
	CashotSystem system = CashotSystem.getInstance();

	@FXML
	Button cBtn;

	/**
	 * Initializes the screen.
	 * 
	 * @throws IOException
	 */
	public void initialize() throws IOException {
		// Load items ?
		system.setController(this);

		system.loadItems();
		system.loadEmployees();

		// REMOVE THIS LATER. I'M LAZY AND TIRED OF SIGNING IN EVERY TIME
		/*
		 * for(Employee employee: system.getEmployees()){
		 * System.out.println("test2");
		 * if(employee.getUserName().equals("admin") &&
		 * employee.getEmployeePassword().equals("admin") &&
		 * employee.isAdmin().equals("TRUE")){ system.setSignedIn(employee);
		 * System.out.println(employee); break; } }
		 */
	}

	@FXML
	private AnchorPane content;
	@FXML
	private TextArea adminTextArea;
	@FXML
	private Button btnLogin;
	// For admin login screen
	@FXML
	private TextField adminUsrName;
	@FXML
	private TextField adminUsrPw;
	// For Employee login screen
	@FXML
	private TextField employeeUsrName;
	@FXML
	private TextField employeeUsrPw;
	// For Employees
	@FXML
	private TextField inputField;
	@FXML
	private TextArea outputField;

	@Override
	/**
	 * handles events. Currently does nothing.
	 * 
	 * @param event
	 */
	public void handle(Event event) {

	}

	/**
	 * Loads the current cashier. If the cashier is already logged in, skip the
	 * login page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void loadCashier(Event event) throws IOException {
		try {
			if (system.getSignedIn().isAdmin().equals("TRUE") || system.getSignedIn().getCashier().equals("TRUE")) {
				bypassEmployeeLogin(event);
			} else {
				loadEmployeeLogin(event);
			}
		} catch (Exception e) {
			loadEmployeeLogin(event);
		}
	}

	/**
	 * Loads the login page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void loadEmployeeLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/employeeLoginScreen.fxml"));
		content.getChildren().setAll(pane);
	}

	/**
	 * Skips the login page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void bypassEmployeeLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/cashier.fxml"));
		content.getChildren().setAll(pane);
	}

	/**
	 * Loads the main screen.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
		content.getChildren().setAll(pane);
	}

	/**
	 * Loads administer page. If the user is not an admin, loads the login page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void loadAdminister(Event event) throws IOException {
		try {
			if (system.getSignedIn().isAdmin().equals("TRUE")) {
				bypassAdminLogin(event);
			} else {
				loadAdminLogin(event);
			}
		} catch (Exception e) {
			loadAdminLogin(event);
		}
	}

	/**
	 * Loads the admin page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void bypassAdminLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}

	/**
	 * Loads the admin login page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void loadAdminLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/adminLoginScreen.fxml"));
		content.getChildren().setAll(pane);
	}

	/**
	 * Loads the training page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void loadTraining(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/Training.fxml"));
		content.getChildren().setAll(pane);
	}

	// public void addEmployeeFromAdmin(Event event) throws IOException{
	// int ID =
	// String userName = inputField.getText();
	// Employee newEmployee = new Employee(, data[1], data[2],
	// Integer.parseInt(data[3]), data[4]);
	// CashotSystem.addEmployee(newEmployee);
	// }
	/**
	 * Loads the viewEmployees page.
	 * 
	 * @param event
	 */
	public void viewEmployees(Event event) {
		String str = CashotSystem.generateEmployeeString();
		adminTextArea.setText(str);
	}

}
