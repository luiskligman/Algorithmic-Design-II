public class Fruit implements Comparable<Fruit> {

	private String type;
	private double weight;
	
	//Default Constructor
	public Fruit() {
		this.setType("Apple");
		this.setWeight(1.0);
	}
	
	//Param Constructor
	public Fruit(String aType, double aWeight) {
		if(aType.equalsIgnoreCase("apple") || aType.equalsIgnoreCase("orange") ||
				aType.equalsIgnoreCase("banana") || aType.equalsIgnoreCase("kiwi") ||
				aType.equalsIgnoreCase("tomato"))
			this.setType(aType);
		if(aWeight > 0)
			this.setWeight(aWeight);
	}
	
	//Accessors
	public String getType() {
		return this.type;
	}
	public double getWeight() {
		return this.weight;
	}
	
	//Mutators
	public void setType(String aType) {
		if(aType != null) {
			this.type = aType;
		}
		else {
			this.type = "Apple";
		}
	}
	
	public void setWeight(double aWeight) {
		if(aWeight > 0) {
			this.weight = aWeight;
		}
		else {
			this.weight = 1.0;
		}
	}
	
	public String toString() {
		return this.type+" "+this.weight;
	}
	
	public int compareTo(Fruit aFruit) {
		//Comparing weights of fruits
		if(this.weight > aFruit.getWeight()) //This fruit weighs more than the given fruit
			return 1;
		else if(this.weight < aFruit.getWeight()) //This fruit weighs less than the given fruit
			return -1;
		
		//fruits have equal weights
		else if(this.type.compareTo(aFruit.getType()) < 0) //this.type comes before aFruit.getType, returning a neg value
			return -1;
		else if(this.type.compareTo(aFruit.getType()) > 0)//aFruit.getType comes before this.type, returning a pos value
				return 1;
		
		//Fruit does not exist
		else
			return -1;
	}
}
