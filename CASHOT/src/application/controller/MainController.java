package application.controller;

import java.io.IOException;

import application.model.CashotSystem;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class MainController implements EventHandler {
	
	
	public void initialize( ) throws IOException{
		//Load items ?
		CashotSystem system = new CashotSystem();
		system.loadEmployees();
	}
	
	@FXML private AnchorPane content;
	@FXML private TextArea adminTextArea;
	
	
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
	public void loadTraining(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/Training.fxml"));
		content.getChildren().setAll(pane);
	}		
	public void viewEmployees(Event event) {
		String str = CashotSystem.generateEmployeeString();
		adminTextArea.setText(str);
	}
	
	
	
}
