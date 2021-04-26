package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import application.model.CashotSystem;
import application.model.Employee;
import application.model.Item;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * The CashierLoginController class controls the cashier's login screen. This makes sure the employee has the proper permissions to make and log new orders.
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */

public class CashierLoginController implements EventHandler{
	@FXML TextField cashierUsername;
	@FXML TextField cashierPassword;
	@FXML Label logInIncorrect;
	@FXML Button btnLogin;
	String inputUN;
	String inputPW;
	@FXML private AnchorPane content;
	
CashotSystem system = CashotSystem.getInstance();
	/**
	 * Initializes the screen.
	 * @throws IOException
	 */
	public void initialize( ) throws IOException{
		//Load items ?
		system.setController(this);
		

}
	/**
	 * loadMain changes the screen to main.fxml.
	 * @param event
	 * @throws IOException
	 */
	public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
		content.getChildren().setAll(pane);
	}
	/**
	 * loadCashier changes the screen to cashier.fxml.
	 * @param event
	 * @throws IOException
	 */
	public void loadCashier(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/cashier.fxml"));
		content.getChildren().setAll(pane);
	}
	
	/**
	 * Sets the label for letting the user know they have incorrect information to blank to hide it.
	 * @param event
	 */
	public void setTextToBlank(Event event){
	//key.KEY_PRESSED;
	logInIncorrect.setText("");
	//System.out.println("Test");
}
/**
 * Happens when the user presses enter or pressed log in, this method will check to see what information has been placed in the text fields, and compare them to the existing employees. If the employee is nonexistent, the label will appear.
 * @param event
 */
	@Override
	public void handle(Event event) {
		//System.out.println("test1");
		inputUN = cashierUsername.getText();
		boolean loggedIn = false;
		inputPW = cashierPassword.getText();
		logInIncorrect.setText("");
		//logInIncorrect.setVisible(false);
		for(Employee employee: system.getEmployees()){
			//System.out.println("test2");
			if(employee.getUserName().equals(inputUN) && employee.getEmployeePassword().equals(inputPW) && (employee.getCashier().equals("TRUE") || employee.isAdmin().equals("TRUE"))){
				try {
					system.setSignedIn(employee);
					loadCashier(event);
					//logInIncorrect.setText("");
					loggedIn = true;
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				break;
			}
		}
		if(loggedIn == false){
			//System.out.println("test");
			logInIncorrect.setText("Incorrect login information. Please try again.");
		}
			
	}
}