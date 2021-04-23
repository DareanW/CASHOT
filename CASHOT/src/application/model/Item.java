package application.model;

public class Item {
	public String itemName;
	double itemPrice;
	public int row;
	public int column;
	
	public Item( String name, double price, int row, int column){
		this.itemName = name;
		this.itemPrice = price;
		this.row = row;
		this.column = column;
	}
	
	public Item(){
		
	}
	
	public double getPrice(){
		return this.itemPrice;
	}
	
	public String getName() {
		return this.itemName;
	}
	
	public void setPrice(int newPrice){
		this.itemPrice = newPrice;
	}
	
	public void setName(String newName) {
		this.itemName = newName;
	}
	
	
	public String toString() {
		String str = this.itemName + " : $" + this.itemPrice;
		return str;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
}
