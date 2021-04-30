package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.model.CashotSystem;
import application.model.Item;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * The editItemController is the controller for the editItems.fxml view and will
 * update it whenever an item is updated, added, or removed.
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */

public class EditItemsController implements EventHandler {

	@FXML
	Button addItem;
	@FXML
	Button deleteItem;
	@FXML
	Button editItem;

	@FXML
	TextField addName;
	@FXML
	TextField addPrice;
	@FXML
	TextField addRow;
	@FXML
	TextField addColumn;
	@FXML
	TextField deleteName;
	@FXML
	TextField editCurrName;
	@FXML
	TextField editNewName;
	@FXML
	TextField editNewPrice;
	@FXML
	TextField editNewRow;
	@FXML
	TextField editNewColumn;

	@FXML
	TextField resultOutput;
	@FXML
	AnchorPane content;

	ArrayList<Item> itemsInOrder;

	static CashotSystem system;

	@Override
	public void handle(Event event) {

	}

	/**
	 * initialize will set up everything the controller will need in order to
	 * function
	 * @throws IOException
	 */
	
	public void initialize() throws IOException {
		// Load items ?
		system = CashotSystem.getInstance();

		system.setController(this);
	}

	/**
	 * addItem method will add a new item to the list of available buttons
	 * 
	 * @param event
	 */
	public void addItem(Event event) {

		try {
			String name = addName.getText();
			// double price = Double.parseDouble(addPrice.getText());
			String priceString = addPrice.getText();
			priceString = priceString.replace("$", "");
			priceString = priceString.replace(",", "");

			double price = Double.parseDouble(priceString);

			int row = Integer.parseInt(addRow.getText());
			int column = Integer.parseInt(addColumn.getText());
			boolean wasMatched = false;

			Item temp = new Item(name, price, row, column);

			for (Item items : system.getItems()) {
				if (items.getName() == temp.getName()) {
					wasMatched = true;
					resultOutput.setText("This name already exists.");
					break;
				}
				// System.out.println(items);
				if ((items.getRow() == temp.getRow()) && (items.getColumn() == temp.getColumn())) {
					wasMatched = true;
					resultOutput.setText("There is an item already in this position.");
					break;
				}
			}
			if (!wasMatched) {
				system.addItem(temp);
				system.updateItemsCsv(temp);
				resultOutput.setText(name + " has been added!");
			}
			// System.out.println("Bob yo or sup dog");
		} catch (Exception e) {
			resultOutput.setText("You need to enter all fields with information.");
		}
	}

	public void deleteItem(Event event) throws IOException {
		String itemName = deleteName.getText();

		Item itemToRemove = system.getSingleItem(itemName);

		if (itemToRemove != null) {
			system.deleteItemCSV(itemName);
			system.removeItem(itemToRemove);
			system.loadItems();
			resultOutput.setText(itemName + " has been successfully removed");
		} else {
			resultOutput.setText("Item \"" + itemName + "\" not found");
		}
	}

	/**
	 * editItem method will edit an inputted items data
	 * 
	 * @param event
	 */
	public void editItem(Event event) {

		String newName = "";
		double newPrice = 0;
		int newRow = 0;
		int newColumn = 0;

		try {
			String name = editCurrName.getText();

			boolean wasMatched = false;

			// Item temp = new Item(newName, newPrice, newRow, newColumn);

			for (Item items : system.getItems()) {
				if (items.getName().equals(name)) {
					wasMatched = true;
					system.removeItem(items);

					if (editNewPrice.getText().isEmpty()) {
						newPrice = items.getPrice();
					} else {
						newPrice = Double.parseDouble(editNewPrice.getText());
					}

					if (editNewName.getText().isEmpty()) {
						newName = items.getName();
					} else {
						newName = editNewName.getText();
					}

					if (editNewRow.getText().isEmpty())
						newRow = items.getRow();
				} else {
					newRow = Integer.parseInt(editNewRow.getText());
				}

				if (editNewColumn.getText().isEmpty()) {
					newColumn = items.getColumn();
				} else {
					newColumn = Integer.parseInt(editNewColumn.getText());
				}

			}

			Item temp = new Item(newName, newPrice, newRow, newColumn);

			if (wasMatched) {
				system.addItem(temp);
				system.editItemsCsv(temp, name);
				resultOutput.setText(name + " has been successfully updated to the contents of " + newName);
				system.loadItems();
			}
			// System.out.println("Bob yo or sup dog");
		} catch (Exception e) {
			resultOutput.setText("You need to enter all fields with information.");
		}
	}

	/**
	 * loadAdmin method loads the admin screen
	 * @param event
	 * @throws IOException
	 */
	public void loadAdmin(Event event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("/application/view/administor.fxml"));
		content.getChildren().setAll(pane);
	}

}
