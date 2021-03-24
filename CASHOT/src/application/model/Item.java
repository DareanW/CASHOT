package application.model;

public class Item {
	private String itemName;
	private int itemPrice;
	
	public Item( String name, int price){
		this.itemName = name;
		this.itemPrice = price;
	}
	
	public int getPrice(){
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
	
}
