package application.controller;

import java.io.IOException;

import application.model.CashotSystem;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainController implements EventHandler {
	
	
	public void initialize( ) throws IOException{
		//Load items ?
		CashotSystem system = new CashotSystem();
		system.loadEmployees();
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
	
	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		// Handle button click
	}
	
	public void loadCashier(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/cashier.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadAdminister(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}
	public void loadTraining(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/Training.fxml"));
		content.getChildren().setAll(pane);
	}	
	public void loadAdminLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/adminLoginScreen.fxml"));
		content.getChildren().setAll(pane);
	}
	public void loadEmployeeLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/employeeLoginScreen.fxml"));
		content.getChildren().setAll(pane);
	}
	
	
	
	public void viewEmployees(Event event) {
		String str = CashotSystem.generateEmployeeString();
		adminTextArea.setText(str);
	}
	
	
	
}
