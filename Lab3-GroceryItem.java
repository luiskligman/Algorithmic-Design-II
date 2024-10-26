public class GroceryItem {

	private String name;
	private double value;
	
	//Default Constructor
	public GroceryItem() {
		this.name = "none";
		this.value = 0;
	}
	
	//Param Constructor
	public GroceryItem(String aName, double aPrice) {
		this.setName(aName);
		this.setValue(aPrice);
	}
	
	//Accessors
	public String getName() {
		return this.name;
	}
	public double getValue() {
		return this.value;
	}
	
	//Mutators
	public void setName(String aName) {
		if(aName != null) {
			this.name = aName;
		}
		else {
			this.name = "none";
		}
	}
	public void setValue(double aPrice) {
		if(aPrice > 0)
			this.value = aPrice;
	}
	
	public String toString() {
		//Grocery Item Name: <<Name>> Value: <<Value>>
		return "Grocery Item Name: "+this.name+" Value: "+this.value;
	}
	
	
	public boolean equals(GroceryItem aGroceryItem) {
		return aGroceryItem != null &&
				this.name.equals(aGroceryItem.getName()) &&
				this.value == aGroceryItem.getValue();
	}
}
