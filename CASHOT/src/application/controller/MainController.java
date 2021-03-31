package application.controller;

import java.io.IOException;

import application.model.CashotSystem;
import application.model.Item;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements EventHandler {
	
	

	
	@FXML private AnchorPane content;
	@FXML private TextArea adminTextArea;
	
	@FXML Button cBtn;
	
	public void initialize( ) throws IOException{
		//Load items ?
		CashotSystem system = new CashotSystem();
		system.setController(this);
		
		system.loadEmployees();
		
	}
	
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
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administer.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void viewEmployees(Event event) {
		String str = CashotSystem.generateEmployeeString();
		adminTextArea.setText(str);
	}	
}
