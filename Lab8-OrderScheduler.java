public class OrderScheduler {
	// MinHeap of type Order representing the orders waiting to be cooked
	MinHeap<Order> orders = new MinHeap<Order>();

	public Order currentOrder;
	public int currentMinute = 0;
	public int totalOrders = 0;
	public double summedWaitingTimes = 0;

	public void addOrder(Order aOrder) {
		if (currentOrder == null)
			currentOrder = aOrder;
		else
			orders.add(aOrder);
		totalOrders++;
	}

	public void advanceOneMinute() {
		currentMinute++;
		int waitingTime = 0;

		currentOrder.cookForOneMinute();

		// Means cooking process is done
		if (currentOrder.getCookingTimeLeft() == 0) {
			waitingTime = currentMinute - currentOrder.getArrivalTime();

			// Add waiting time to summed waiting times
			summedWaitingTimes += waitingTime;

			// Check if there are more orders waiting in the heap
			if (orders.size() > 0) {
				currentOrder = orders.remove(); // Remove and set the next order as current
			} 
			else {
				currentOrder = null; // If heap is empty, set current order to null
			}
		}
	}

	public boolean isDone() {
		return currentOrder == null;
	}

	public double getAverageWaitingTime() {
		return summedWaitingTimes / totalOrders;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}
}
