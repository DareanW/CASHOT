package application.model;

/**
 * The Item class holds data for the creation of an item and its respective 
 * name, price, row, and column
 * 
 * @author Darean Wilde grl167 63678621
 * @author Jacob Shawver fww704 36242636
 * @author Majerus Sims hug180 79595196
 * @author Alexander Delgado tvh991 79595706
 *
 */
public class Item {
	public String itemName;
	double itemPrice;
	public int row;
	public int column;

	/**
	 * Constructor for the item
	 * @param name
	 * @param price
	 * @param row
	 * @param column
	 */
	public Item(String name, double price, int row, int column) {
		this.itemName = name;
		this.itemPrice = price;
		this.row = row;
		this.column = column;
	}

	/**
	 * item method that was used for testing
	 */
	public Item() {

	}

	/**
	 * getPrice method returns the price of the item
	 * @return itemPrice
	 */
	public double getPrice() {
		return this.itemPrice;
	}

	/**
	 * getName method returns the name of the item
	 * @return itemName
	 */
	public String getName() {
		return this.itemName;
	}

	/**
	 * setPrice method sets the new price of the item
	 * @param newPrice
	 */
	public void setPrice(int newPrice) {
		this.itemPrice = newPrice;
	}

	/**
	 * setName method sets the new name of the item
	 * @param newName
	 */
	public void setName(String newName) {
		this.itemName = newName;
	}

	/**
	 * toString for item
	 */
	@Override
	public String toString() {
		String str = this.itemName + " : $" + this.itemPrice;
		return str;
	}

	/**
	 * getRow returns the row of the item
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * getColumn returns the column of the item
	 * @return column
	 */
	public int getColumn() {
		return column;
	}

}