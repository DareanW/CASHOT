package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import application.model.CashotSystem;
import application.model.Employee;
import application.model.Item;
import application.model.Order;
import application.model.Receipt;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;




public class TrainingRingUpCustomerController implements EventHandler {

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
	
	@FXML TextArea receiptNames;
	@FXML TextArea receiptPrices;
	@FXML TextArea receiptTotal;
	@FXML TextArea moneyToCollect;
	
	Button cashierButtons[][];
	
	ArrayList<Item> itemsInOrder;
  
	public static double moneyToCalculate = 0;
	
	
	@FXML private AnchorPane content;
	CashotSystem system;
	String moneyString = "";

	public static double total = 0.00;
	public static double customerPaid = 0.00;
	
	public void initialize( ) throws IOException{
		//Load items ?
		system = CashotSystem.getInstance();
		
		system.setController(this);
		
		system.loadEmployees();
		
		
		
		
//		try {
//			system.loadItems();
//		} catch (Error e) {
//			e.printStackTrace();
//		}
		
		//system.getItemsInButtons();
		
		//system.newOrder();
		itemsInOrder = new ArrayList<Item>();
		String strName = "";
		String strPrice = "";
		String strTotal = "";
		double tax = 0.00;
		double price = 0.00;
		
		for (Item item: TrainingController.itemsInOrder){
			price = item.getPrice();
			tax = Math.round(item.getPrice() * 100.00) / 100.00;
			tax = (0.0825 * tax);
			tax = Double.parseDouble(String.format("%.02f", tax));
			moneyString += "$" + String.format("%.02f", item.getPrice()) + " - " + item.getName() + " + $" + String.format("%.02f", tax) + " tax\n";
			//System.out.println("Test");
//			str += String.format("%-50s %15s\n", item.getName(), moneyString);
			//strName += item.getName() + "\n";
			//strPrice += moneyString + "\n";
//			System.out.printf("%-50s %15s\n", item.getName(), moneyString);
//			System.out.print(str);
//			receiptList.setText(str);
			total += item.getPrice() + tax;
		}
		moneyString += "-------------------\n" + "\t\t\t\t$" + String.format("%.02f", total) + "\n";
		moneyToCollect.setText(moneyString);
		moneyToCalculate = Double.parseDouble(String.format("%.02f", total));
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
		
		 moneyToCalculate =  Double.parseDouble(String.format("%.02f", total));
		
		//receiptNames.setText(strName);
		//receiptPrices.setText(strPrice);
		//total = system.getOrderTotal();
		//strTotal = CashotSystem.dblToMoneyString((total));
		//receiptTotal.setText(strTotal);
	
	}

	@Override
	public void handle(Event event) {
		//for (int i = 0; i < 6; i++){
			//for (int j = 0; j < 4; j++){
				//if (cashierButtons[i][j] == event.getSource()){
					//itemsInOrder = system.addItemToOrder(i,j);
//					receiptList.setText(itemsInOrder.toString());
					
			}
		//}
	//}
	
//	public void nameScroll(Event event){
//		receiptPrices.setScrollTop(receiptNames.getScrollTop());
//	}
//	
//	public void priceScroll(Event event){
//		receiptNames.setScrollTop(receiptPrices.getScrollTop());
//	}
	
	
	
	/*public void loadMain(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/main.fxml"));
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
	*/
//	public void loadItems() throws IOException{
//		system.loadItems();
//	}
	
	/*public void loadItems() throws IOException {
		//String employeeName, String userName, String employeePassword, int ID
		String row;
		
		BufferedReader csvReader = new BufferedReader( new FileReader("data/test.csv") );
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			Item tempItem = new Item(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
			addItem(tempItem);
			
		}
		csvReader.close();
		
		hideUnimplementedButtons();
	}
	*//*
	public void addItem(Item item){
//		itemMatrix[item.getRow()][item.getColumn()] = item;
//		controller.setButton(item);
//		System.out.println(itemMatrix[item.getRow()][item.getColumn()]);
		Button button = cashierButtons[item.getRow()][item.getColumn()];
		double price = item.getPrice();
		String moneyString = CashotSystem.dblToMoneyString(price);
		
		button.setText(item.getName() + "\n" + moneyString);
		
	}*/
	public void loadTrainingController(Event event) throws IOException {
		total = 0.00;
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/Training.fxml"));
		content.getChildren().setAll(pane);
	}
	
	public void ringUpOrder() throws IOException{
		//CashierController.system.ringUp();
		//CashierController.system.newOrder();
		//receiptTotal.setText("");
		if(moneyToCalculate > 0.00){
			moneyString += "Not enough money paid. Please pay total amount.\n";
			moneyToCollect.setText(moneyString);
		}
		else{
			Receipt.TraineePrintReceipt(CashotSystem.order, "Trainee");
			customerPaid = 0.00;
			total = 0.00;
			loadTrainingController(null);
			//Put complete transaction calls here.
		}
		
	}
	
	public void hideUnimplementedButtons() {
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 4; j++){
				Button button = cashierButtons[i][j];
				if (button.getText().equals("")){
					button.setVisible(false);
				}
			}
		}
	}
	public void add1(){
		customerPaid -= 0.01;
		moneyToCalculate += 0.01;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $0.01:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add5(){
		customerPaid -= 0.05;
		moneyToCalculate += 0.05;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $0.05:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add10(){
		customerPaid -= 0.10;
		moneyToCalculate += 0.10;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $0.10:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add25(){
		customerPaid -= 0.25;
		moneyToCalculate += 0.25;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $0.25:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add50(){
		customerPaid -= 0.50;
		moneyToCalculate += 0.50;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $0.50:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add100(){
		customerPaid -= 1.00;
		moneyToCalculate += 1.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $1.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add200(){
		customerPaid -= 2.00;
		moneyToCalculate += 2.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $2.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add500(){
		customerPaid -= 5.00;
		moneyToCalculate += 5.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $5.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add1000(){
		customerPaid -= 10.00;
		moneyToCalculate += 10.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $10.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add2000(){
		customerPaid -= 20.00;
		moneyToCalculate += 20.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $20.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add5000(){
		customerPaid -= 50.00;
		moneyToCalculate += 50.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $50.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void add10000(){
		customerPaid -= 100.00;
		moneyToCalculate += 100.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Added $100.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus1(){
		customerPaid += 0.01;
		moneyToCalculate -= 0.01;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $0.01:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus5(){
		customerPaid += 0.05;
		moneyToCalculate -= 0.05;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $0.05:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus10(){
		customerPaid += 0.10;
		moneyToCalculate -= 0.10;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $0.10:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus25(){
		customerPaid += 0.25;
		moneyToCalculate -= 0.25;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $0.25:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus50(){
		customerPaid += 0.50;
		moneyToCalculate -= 0.50;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $0.50:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus100(){

		customerPaid += 1.00;
		moneyToCalculate -= 1.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $1.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus200(){
		customerPaid += 2.00;
		moneyToCalculate -= 2.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $2.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus500(){
		customerPaid += 5.00;
		moneyToCalculate -= 5.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $5.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus1000(){
		customerPaid += 10.00;
		moneyToCalculate -= 10.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $10.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus2000(){
		customerPaid += 20.00;
		moneyToCalculate -= 20.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $20.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus5000(){
		customerPaid += 50.00;
		moneyToCalculate -= 50.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $50.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
	public void minus10000(){
		customerPaid += 100.00;
		moneyToCalculate -= 100.00;
		moneyToCalculate = Double.parseDouble(String.format("%.02f", moneyToCalculate));
		moneyString += "Paid $100.00:\t\t$" + String.format("%.02f", moneyToCalculate) + "\n";
		moneyToCollect.setText(moneyString);
		receiptTotal.setText("$" + String.format("%.02f", moneyToCalculate));
	}
}
