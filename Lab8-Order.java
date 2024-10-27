public class Order implements Comparable<Order> {

	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft;

	// Default Constructor
	public Order() {
		this.setCustomer("none");
		this.setFoodOrder("none");
		this.setCookingTime(1);
		this.setArrivalTime(0);
		this.setCookingTimeLeft(1);
	}

	// Param Constructor
	public Order(String aCustomer, String aFoodOrder, int aCookingTime, int aArrivalTime) {
		this.setCustomer(aCustomer);
		this.setFoodOrder(aFoodOrder);
		this.setCookingTime(aCookingTime);
		this.setArrivalTime(aArrivalTime);
		this.setCookingTimeLeft(aCookingTime);
	}

	// Accessors
	public String getCustomer() {
		return this.customer;
	}

	public String getFoodOrder() {
		return this.foodOrder;
	}

	public int getCookingTime() {
		return this.cookingTime;
	}

	public int getArrivalTime() {
		return this.arrivalTime;
	}

	public int getCookingTimeLeft() {
		return this.cookingTimeLeft;
	}

	// Mutators
	public void setCustomer(String aCustomer) {
		if (aCustomer != null)
			this.customer = aCustomer;
		else
			this.customer = "none";
	}

	public void setFoodOrder(String aFoodOrder) {
		if (aFoodOrder != null)
			this.foodOrder = aFoodOrder;
		else
			this.foodOrder = "none";
	}

	public void setCookingTime(int aCookingTime) {
		if (aCookingTime > 0)
			this.cookingTime = aCookingTime;
		else
			this.cookingTime = 1;
	}

	public void setArrivalTime(int aArrivalTime) {
		if (aArrivalTime > 0)
			this.arrivalTime = aArrivalTime;
		else
			this.arrivalTime = 0;
	}

	public void setCookingTimeLeft(int aCookingTimeLeft) {
		if (aCookingTimeLeft > 0)
			this.cookingTimeLeft = aCookingTimeLeft;
		else
			this.cookingTimeLeft = 1;
	}

	public String toString() {
		return "Customer: " + this.customer + " Order: " + this.foodOrder + " Cooking Time Left: "
				+ this.cookingTimeLeft;
	}

	public int compareTo(Order aOrder) {
		// Compare the Cooking Times of orders
		if (this.cookingTime > aOrder.cookingTime) // This order has a longer time than the given order
			return 1;
		else if (this.cookingTime < aOrder.cookingTime) // this order has a lesser time than the given order
			return -1;
		return 0;
	}

	public void cookForOneMinute() {
		this.cookingTimeLeft--;
	}

	public boolean isDone(Order aOrder) {
		if (aOrder.cookingTimeLeft == 0)
			return true;
		else
			return false;
	}
}
