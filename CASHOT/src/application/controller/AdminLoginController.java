package application.controller;

import java.io.IOException;
import application.model.CashotSystem;
import application.model.Employee;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;

/**
 * The AdminLoginController is the controller for the adminLoginScreen.fxml and
 * will update it whenever data changes
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 */

public class AdminLoginController implements EventHandler {
	@FXML
	TextField adminUsrName;
	@FXML
	TextField adminUsrPw;
	@FXML
	Button btnLogin;
	@FXML
	Label logInIncorrect;
	String inputUN;
	String inputPW;
	@FXML
	private AnchorPane content;

	CashotSystem system = CashotSystem.getInstance();

	public void initialize() throws IOException {

		system.setController(this);

		// system.getEmployees();

	}

	/**
	 * loadMain method will launch the orginal view that user is greeted with
	 * 
	 * @param event
	 * @throws IOException
	 */

	public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
		content.getChildren().setAll(pane);
	}

	/**
	 * loadAdminisister method will load the administor view when the user logs
	 * 
	 * @param event
	 * @throws IOException
	 */

	public void loadAdminister(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}

	/**
	 * setTextToBlank will clear the textfields in the view
	 * 
	 * @param event
	 */

	public void setTextToBlank(Event event) {
		// key.KEY_PRESSED;
		logInIncorrect.setText("");
		// System.out.println("Test");
	}

	/**
	 * handle method will check what the user inputs on the login screen If the
	 * user has the right login then he/she can proceed to the admin view
	 * 
	 * @param event
	 */

	@Override
	public void handle(Event event) {
		// System.out.println("test1");
		inputUN = adminUsrName.getText();
		inputPW = adminUsrPw.getText();
		logInIncorrect.setText("");
		boolean loggedIn = false;

		for (Employee employee : CashotSystem.getEmployees()) {
			// System.out.println("test2");
			if (employee.getUserName().equals(inputUN) && employee.getEmployeePassword().equals(inputPW)
					&& employee.isAdmin().equals("TRUE")) {
				try {
					system.setSignedIn(employee);
					loadAdminister(event);
					// logInIncorrect.setText("");
					loggedIn = true;
				} catch (IOException e) {

					e.printStackTrace();
				}
				break;
			} else if (employee.getUserName().equals(inputUN) && employee.getEmployeePassword().equals(inputPW)
					&& (employee.getCashier().equals("TRUE") || employee.isAdmin().equals("TRUE"))) {
				logInIncorrect.setText("Employee does not have Admin status.");
				loggedIn = true;
			}
		}
		if (loggedIn == false) {
			// System.out.println("test");
			logInIncorrect.setText("Incorrect login information. Please try again.");
		}
	}
}