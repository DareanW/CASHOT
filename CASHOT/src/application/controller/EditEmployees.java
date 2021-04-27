package application.controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import application.model.CashotSystem;
import application.model.Employee;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class EditEmployees implements EventHandler {

	@FXML Button removeBtn; // for remove button
	@FXML Button viewBtn; // for view button
	@FXML Button btnCT;// for complete training button 
	@FXML Button adminBtn; // for promote to admin button
	@FXML Button backBtn; // for back button
	
	@FXML private TextArea textArea;
	@FXML private TextField userInput;
	@FXML private AnchorPane content;
	CashotSystem system;
	
	public void initialize( ) throws IOException{
		system = CashotSystem.getInstance();
		//system.setController(this);
		
	}
	
	
	public void loadAdminister(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}
	@Override
	public void handle(Event e) {
		
		
	}
	@FXML 
	public void removeEmployee(ActionEvent e) throws IOException{
		int id=Integer.parseInt(userInput.getText());
		Employee temp;
		for(Employee i: CashotSystem.getEmployees()){
			if(i.getID()==id){
				temp=i;//maybe write the name of employee removed to the screen
				system.removeEmployee(i);
				break;
			}
		}
		String result =CashotSystem.callEmployeeMethods(id, "remove");
		if(result == "FALSE")
			textArea.setText("Employee not found\n");
		else
			textArea.setText("Employee: "+id+ " sucessfully removed");
		
	}
	
	@FXML 
	public void completeTraining(ActionEvent e) throws IOException{
		int id;
		try{
		id = Integer.parseInt(userInput.getText());
		String result = CashotSystem.callEmployeeMethods(id,"completeTraining");
		if(result == "TRUE")
			textArea.setText("Employee "+id+ " sucessfully promoted to Cashier");
		
	}catch(Exception exception){
		textArea.setText("Employee not found\n");
	}
	}

	@FXML
	public void promoteToAdmin(ActionEvent e) throws IOException{
		int id;
		try{
		id = Integer.parseInt(userInput.getText());
		String result = CashotSystem.callEmployeeMethods(id,"promoteToAdmin");
		if(result == "TRUE")
			textArea.setText("Employee "+id+ " sucessfully promoted to Admin");
	
	}catch(Exception exception){
		textArea.setText("Employee not found\n");
	}
	}
	@FXML
	public void viewEmployees(ActionEvent e) throws IOException{
		
		String temp="";
				String row;
		BufferedReader csvReader = new BufferedReader( new FileReader("data/employees.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			temp += "Name: " + data[0] + "\nID: " + data[3] + "\nCurrent work status:";
			if(data[4].equals("TRUE"))
			temp+=" Administrator\n\n";
			else if(data[6].equals("TRUE"))
				temp+=" Cashier\n\n";
			else 
				temp+= " Trainee\n\n";
		}
		/*
		for(Employee i: CashotSystem.getEmployees()){
			if(i.isAdmin().equals("TRUE")){
				temp+=("Name: "+i.getEmployeeName()+"\n"+"ID: "+i.getID()+"\n"+"Current Work Status: Administrator\n\n");
			}
			else if(i.getTrainiee().equals("TRUE"))
				temp+=("Name: "+i.getEmployeeName()+"\n"+"ID: "+i.getID()+"\n"+"Current Work Status: Training\n\n");
			
			else if(i.getCashier().equals("TRUE"))
				temp+=("Name: "+i.getEmployeeName()+"\n"+"ID: "+i.getID()+"\n"+"Current Work Status: Cashier\n\n");
		}*/
		textArea.setText(temp);

	}
	
	
}
