package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import application.model.CashotSystem;
import application.model.Employee;
import application.model.Item;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EditItemsController implements EventHandler {

	@FXML Button addItem;
	@FXML Button deleteItem;
	@FXML Button editItem;
	
	@FXML TextField addName;
	@FXML TextField addPrice;
	@FXML TextField deleteName;
	@FXML TextField editCurrName;
	@FXML TextField editNewName;
	@FXML TextField editNewPrice;
	
	ArrayList<Item> itemsInOrder;
	
	@Override
	public void handle(Event event) {
		
	}
	
	public void addItem(Item item){
		String name = addName.getText();
		String price = addPrice.getText();
		
		for (Item items : Item.getItems()){
			Item temp = new Item(name, price, );
		
		}
	}
	
	public void deleteItem(Item item){
		
	}
	
	public void editItem(Item item){
		
	}
}
