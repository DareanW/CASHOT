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
import javafx.scene.input.KeyEvent;


public class AdminLoginController implements EventHandler{
	@FXML TextField adminUsrName;
	@FXML TextField adminUsrPw;
	@FXML Button btnLogin;
	@FXML Label logInIncorrect;
	String inputUN;
	String inputPW;
	@FXML private AnchorPane content;
	
CashotSystem system = CashotSystem.getInstance();
	
	public void initialize( ) throws IOException{
		
		system.setController(this);
		
//		system.getEmployees();
		

}
	public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadAdminister(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}

	public void setTextToBlank(Event event){
	//key.KEY_PRESSED;
	logInIncorrect.setText("");
	//System.out.println("Test");
}
	@Override
	public void handle(Event event) {
		//System.out.println("test1");
		inputUN = adminUsrName.getText();
		inputPW = adminUsrPw.getText();
		logInIncorrect.setText("");
		boolean loggedIn = false;
	
		for(Employee employee: system.getEmployees()){
			//System.out.println("test2");
			if(employee.getUserName().equals(inputUN) && employee.getEmployeePassword().equals(inputPW) && employee.isAdmin().equals("TRUE")){
				try {
					system.setSignedIn(employee);
					loadAdminister(event);
					//logInIncorrect.setText("");
					loggedIn = true;
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				break;
			}
			else if (employee.getUserName().equals(inputUN) && employee.getEmployeePassword().equals(inputPW) && (employee.getCashier().equals("TRUE") || employee.isAdmin().equals("TRUE"))){
				logInIncorrect.setText("Employee does not have Admin status.");
				loggedIn = true;
			}
		}
		if(loggedIn == false){
			//System.out.println("test");
			logInIncorrect.setText("Incorrect login information. Please try again.");
		}
	}
}