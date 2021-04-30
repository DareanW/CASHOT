package application.model;

import javafx.scene.media.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import application.controller.RingUpCustomerController;
import application.controller.TrainingRingUpCustomerController;
import application.model.Employee;

/**
 * The Receipt class holds information for receipts such as the
 * date, time, update log, and print of its creation 
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */
public class Receipt {

	/**
	 * TraineePrintReceipt method to get the contents of 
	 * receipt and print it via training option
	 * 
	 * @param order
	 * @param Trainee
	 */
	public static void TraineePrintReceipt(Order order, String Trainee) {
		try {
			Media sound = new Media(new File("data/ChaChing.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		} catch (Exception e) {
		}

		LocalDateTime dateTime = Order.getCurrTimeDate();
		int year = dateTime.getYear();
		int month = dateTime.getMonthValue();
		int day = dateTime.getDayOfMonth();

		int hour = dateTime.getHour();
		int minute = dateTime.getMinute();
		// minute = 9;
		int second = dateTime.getSecond();
		String newMinute = "", newSecond = "";
		if (minute < 10)
			newMinute = "0" + minute;
		else
			newMinute = String.format("%d", minute);

		if (second < 10)
			newSecond = "0" + second;
		else
			newSecond = String.format("%d", second);
		// newMinute = minute.toString();
		String formatDate = String.format("%15s %10s", (month + "-" + day + "-" + year),
				(hour + ":" + newMinute + ":" + newSecond));
		// String formatTime = String.format("%20s",);

		String str = String.format("\n=================================\n\n");
		str += formatDate;
		// str += String.format("\n%s\n", formatTime);
		str += String.format("\n%15s %10s \n", "00000000", "Trainee");

		str += String.format("%28s \n", "________________________");

		for (Item item : order.getItems()) {
			str += String.format(" %15s  %5s\n", item.getName(), CashotSystem.dblToMoneyString(item.getPrice()));
		}

		String moneyString = CashotSystem.dblToMoneyString(order.getTotal());

		str += String.format("\n %15s  %5s", "Total:", moneyString);

		str += String.format("\n %15s  %5s", "Total + tax:",
				String.format("$%.02f", (TrainingRingUpCustomerController.total)));

		str += String.format("\n %15s  %5s", "Customer paid:",
				String.format("$%.02f", (TrainingRingUpCustomerController.customerPaid)));

		if (TrainingRingUpCustomerController.moneyToCalculate != 0.00)
			str += String.format("\n\n %15s change.", String.format("$%s",
					String.format("%.02f", (TrainingRingUpCustomerController.moneyToCalculate) * -1.00)));
		else
			str += String.format("\n\n %15s change.",
					String.format("$%s", String.format("%.02f", (TrainingRingUpCustomerController.moneyToCalculate))));

		// rWriter.write("\n\n=================================\n\n");
		str += String.format("\n\nThank you, and have a great day!\n\n=================================\n\n\n");

		System.out.println(str);
	}

	/**
	 * printReceipt method to print the information of a receipt
	 * @param order
	 * @param employee
	 * @throws IOException
	 */
	public static void printReceipt(Order order, Employee employee) throws IOException {
		// String ChaChing = "data/ChaChing.wav";
		try {
			Media sound = new Media(new File("data/ChaChing.wav").toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		} catch (Exception e) {
		}
		LocalDateTime dateTime = Order.getCurrTimeDate();
		int year = dateTime.getYear();
		int month = dateTime.getMonthValue();
		int day = dateTime.getDayOfMonth();

		int hour = dateTime.getHour();
		int minute = dateTime.getMinute();
		int second = dateTime.getSecond();
		String newMinute = "", newSecond = "";
		if (minute < 10)
			newMinute = "0" + minute;
		else
			newMinute = String.format("%d", minute);

		if (second < 10)
			newSecond = "0" + second;
		else
			newSecond = String.format("%d", second);

		Path path = Paths.get("Receipts", String.valueOf(year), String.valueOf(month), String.valueOf(day));

		try {
			Files.createDirectories(path);

		} catch (IOException e) {
			System.out.println("Directory already exists");
		}

		File recFile = new File(Paths.get(path.toString(), employee.getEmployeeName() + "-" + dateTime.getHour() + "-"
				+ dateTime.getMinute() + "-" + dateTime.getSecond() + ".txt").toString());
		recFile.createNewFile();

		// File recFile = new File("Receipts/" + year + "/" + month + "/" + day
		// + "receipts.csv");

		FileWriter rWriter = new FileWriter(recFile);

		String formatDate = String.format("%15s %10s", (month + "-" + day + "-" + year),
				(hour + ":" + newMinute + ":" + newSecond));
		// String formatTime = String.format("%20s",);

		String str = String.format("\n=================================\n\n");
		str += formatDate;

		str += String.format("\n%15s %10s \n", employee.getID(), employee.getEmployeeName());

		str += String.format("%28s \n", "________________________");

		for (Item item : order.getItems()) {
			str += String.format("%15s  %5s\n", item.getName(), CashotSystem.dblToMoneyString(item.getPrice()));
		}

		String moneyString = CashotSystem.dblToMoneyString(order.getTotal());

		str += String.format("\n %15s  %5s", "Total:", moneyString);

		str += String.format("\n %15s  %5s", "Total + tax:", String.format("$%.02f", (RingUpCustomerController.total)));

		str += String.format("\n %15s  %5s", "Customer paid:",
				String.format("$%.02f", (RingUpCustomerController.customerPaid)));

		if (RingUpCustomerController.moneyToCalculate != 0.00)
			str += String.format("\n\n %15s change.",
					String.format("$%s", String.format("%.02f", (RingUpCustomerController.moneyToCalculate) * -1.00)));
		else
			str += String.format("\n\n %15s change.",
					String.format("$%s", String.format("%.02f", (RingUpCustomerController.moneyToCalculate))));

		// rWriter.write("\n\n=================================\n\n");
		str += String.format("\n\nThank you, and have a great day!\n\n=================================\n\n\n");
		rWriter.write(str);
		// rWriter.write("\n\n=================================\n\n");
		updateLog(str);
		rWriter.flush();
		System.out.println(str);
		rWriter.close();
	}

	/**
	 * updateLog method to update the log files with information from each created receipt
	 * @param str
	 * @throws IOException
	 */
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
