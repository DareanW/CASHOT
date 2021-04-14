package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDateTime;

import application.model.Employee;

public class Receipt{

	/*
	public String toString(){
		String receiptTicket = "";
		
		receiptTicket=receiptTicket + Employee.getID();
		
		return receiptTicket;
	}*/
	
	public static void printReceipt(Order order, Employee employee)throws IOException {
		LocalDateTime dateTime = Order.getCurrTimeDate();
		int year = dateTime.getYear();
		int month = dateTime.getMonthValue();
		int day = dateTime.getDayOfMonth();
		
		Path path = Paths.get("Receipts", String.valueOf(year), String.valueOf(month), String.valueOf(day));

		
		try {
			Files.createDirectories(path);
			
		} catch (IOException e ){
			System.out.println("Directory already exists");
		}
		
		File recFile = new File(Paths.get(path.toString(), employee.getEmployeeName() + "-" + dateTime.getHour() + "-" + dateTime.getMinute() + "-" + dateTime.getSecond() + ".txt" ).toString());
		recFile.createNewFile();
		
//		File recFile = new File("Receipts/" + year + "/" + month + "/" + day + "receipts.csv");
		
		FileWriter rWriter= new FileWriter(recFile);
		String str = String.format("\n=================================\n\n");
		 str += String.format("%27s \n \n", order.getCurrTimeDate().toString());
		str += String.format("%15s %10s \n \n", employee.getID(), employee.getEmployeeName());
										
		str += String.format("%28s \n", "________________________");
		
		for (Item item: order.getItems()){
			str += String.format("%15s %7s \n", item.getName(), CashotSystem.dblToMoneyString(item.getPrice()));
		}
		
		String moneyString = CashotSystem.dblToMoneyString(order.getTotal());
		
		str += String.format("\n\n %15s %5s", "Total:", moneyString);
			
		//rWriter.write("\n\n=================================\n\n");
		str += String.format("\n\n=================================\n\n\n");
		rWriter.write(str);
		//rWriter.write("\n\n=================================\n\n");
		updateLog(str);
		rWriter.flush();
		System.out.println(str);
		rWriter.close();
	}

	private static void updateLog(String str) throws IOException {
		File recLog = new File("Receipts/ReceiptLog.txt");
		
		
		try {
			recLog.createNewFile();
		} catch (IOException e) {
			System.out.println("File already exists");
		}
		
		BufferedWriter logWriter = new BufferedWriter(new FileWriter(recLog, true));
		logWriter.write(str);
		logWriter.flush();
		logWriter.close();

		
	}
}
