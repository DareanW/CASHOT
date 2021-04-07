package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

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




public class AdminController implements EventHandler {
	
	@FXML Button button00;
	@FXML Button button01;
	@FXML Button button02;
	@FXML Button button03;
	@FXML Button button10;
	@FXML Button button11;
	@FXML Button button12;
	@FXML Button button13;
	@FXML Button button20;
	@FXML Button button21;
	@FXML Button button22;
	@FXML Button button23;
	@FXML Button button30;
	@FXML Button button31;
	@FXML Button button32;
	@FXML Button button33;
	@FXML Button button40;
	@FXML Button button41;
	@FXML Button button42;
	@FXML Button button43;
	@FXML Button button50;
	@FXML Button button51;
	@FXML Button button52;
	@FXML Button button53;
	
	Button cashierButtons[][];
	
	@FXML private AnchorPane content;
	CashotSystem system = CashotSystem.getInstance();
	
	public void initialize( ) throws IOException{
		//Load items ?
		system.setController(this);
		
		system.loadEmployees();
		
		
		cashierButtons = new Button[6][4];
		buttonToMatrix();
		
		try {
			loadItems();
		} catch (Error e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void handle(Event event) {
		// TODO Auto-generated method stub
		
	}
	
	public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
		content.getChildren().setAll(pane);
	}
	public void loadAddEmployee(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/AdminAddEmployee.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadTraining(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/Training.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void loadCashierLogin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/employeeLoginScreen.fxml"));
		content.getChildren().setAll(pane);
	}
	
	//work in progress
	public void loadEmployees(Event event){
		
	}
	
	public void addEmployees(Event event){
		
	}
	
	public void editItems(Event event){
		
	}
//	public void loadItems() throws IOException{
//		system.loadItems();
//	}
	
	public void loadItems() throws IOException {
		//String employeeName, String userName, String employeePassword, int ID
		String row;
		
		BufferedReader csvReader = new BufferedReader( new FileReader("data/test.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Item tempItem = new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
			addItem(tempItem);
			
		}
		csvReader.close();
	}
	
	public void addItem(Item item){
//		itemMatrix[item.getRow()][item.getColumn()] = item;
//		controller.setButton(item);
//		System.out.println(itemMatrix[item.getRow()][item.getColumn()]);
		Button button = cashierButtons[item.getRow()][item.getColumn()];
		double price = item.getPrice();
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String moneyString = formatter.format(price);
		
		//button.setText(item.getName() + "\n" + moneyString);
	}
		
	
	public void buttonToMatrix(){
		cashierButtons[0][0] = button00;
		cashierButtons[0][1] = button01;
		cashierButtons[0][2] = button02;
		cashierButtons[0][3] = button03;
		cashierButtons[1][0] = button10;
		cashierButtons[1][1] = button11;
		cashierButtons[1][2] = button12;
		cashierButtons[1][3] = button13;
		cashierButtons[2][0] = button20;
		cashierButtons[2][1] = button21;
		cashierButtons[2][2] = button22;
		cashierButtons[2][3] = button23;
		cashierButtons[3][0] = button30;
		cashierButtons[3][1] = button31;
		cashierButtons[3][2] = button32;
		cashierButtons[3][3] = button33;
		cashierButtons[4][0] = button40;
		cashierButtons[4][1] = button41;
		cashierButtons[4][2] = button42;
		cashierButtons[4][3] = button43;
		cashierButtons[5][0] = button50;
		cashierButtons[5][1] = button51;
		cashierButtons[5][2] = button52;
		cashierButtons[5][3] = button53;
				
	}

	public void setButton(Item item) {
		// TODO Auto-generated method stub
		
	}

}
