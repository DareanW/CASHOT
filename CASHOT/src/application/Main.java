package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Team brand CASHOT's point-of-sale system model PAYHEM is a ground-breaking
 * new technology designed to be your next system. With the ability to print
 * receipts, log who's employed at your store, who's administering these
 * employees, and customization of items! The Main class starts up the system.
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */
public class Main extends Application {
	/**
	 * The start class loads the Main.fxml screen to start the program.
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
			Scene scene = new Scene(root, 800, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main class launches the program.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		launch(args);
	}
}