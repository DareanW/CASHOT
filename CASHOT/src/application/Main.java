package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
//			Parent cashierRoot = FXMLLoader.load(getClass().getResource("/application/view/cashier.fxml"));
//			Scene cashier = new Scene(root,800,800);
//			cashierRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(cashier);
			//
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		launch(args);
	}
}