public class DoubleDoubleLL implements DoubleLLInterface {
	private class ListNode {
		double data;
		ListNode next;
		ListNode prev;
		
		public ListNode(double aData, ListNode aNext, ListNode aPrev) {
			data = aData;
			next = aNext; //Points to the next node
			prev = aPrev; //Points to the previous node
		}
	}
	
	private ListNode head; //First element of the list
	private ListNode current;//Movable iterator / current node of interest
	
	public DoubleDoubleLL() {
		head = current = null;
		}
	
	public void add(double aData) {//Adding to the end of the list
		//Create a new node with the data
		ListNode newNode = new ListNode(aData,null,null);

		//Adding the node to the list
		if(head == null) { //Empty List
			head = current = newNode;//adding a head element
			return;
		}
		
		//Linking newNode to the list
		ListNode temp = head;
		if (temp == null) {
			head = newNode;
		} 
		else {
			while (temp.next != null) {
				temp = temp.next;
				}
			temp.next = newNode;
			newNode.prev = temp;
			}
	}
	
	public void addAfterCurrent(double aData) {
		if(current == null)
			return;
		ListNode newNode = new ListNode(aData,null,null);
		newNode.prev = current;
	    newNode.next = current.next;
	    if (current.next != null) {
	        current.next.prev = newNode;
	    }
	    current.next = newNode;	
	}
	
	//Printing from start to end
	public void print() {
		reset();
		while(current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	public void gotoEnd() {
		if (head == null) { // If the list is empty
	        return;
	    }

	    ListNode temp = head;
	    while (temp.next != null) {
	        temp = temp.next;
	    }
	    current = temp; // Current now should equal the last item in the list
	}
	
	//Accessor
	public double getCurrent() {
		return current.data;
	}
	//Mutator
	public void setCurrent(double aDouble) {
		current.data = aDouble;
	}
	
	//Set current to head
	public void reset() {
		current = head;
	}
	
	public void gotoNext() {
		if(current == null)
			return;
		current = current.next;
		}
	public void gotoPrev() {
		if (current == null || current.prev == null) { // If current is null or there is no previous node
	        return;
	    }
	    current = current.prev;
	}
	
	public void removeCurrent() {
		if (current == null) { // Handle case where current is null
	        return;
	    }
	    if (current.prev != null) {
	        current.prev.next = current.next;
	    } 
	    else {
	        //If current is the head node, update head
	        head = current.next;
	    }
	    if (current.next != null) {
	        current.next.prev = current.prev;
	    }
	    //Move current to the next node
	    current = current.next;
	}
	
	public void remove(double aDouble) {
		reset();
		while(hasMore() == true) {
			if(current.data == aDouble) {
				if (current == null) {
			        // Handle case where current is null
			        return;
			    }
				else if (current.prev != null && current.next != null) {//Current is in the middle
			        // If current is not the first node
			        current.prev.next = current.next;
			        current.next.prev = current.prev;
			        current = current.next;
			    } 
				else if (current.prev == null && current.next != null) {//Current = head
					current = current.next;
					head = current;
				}
				else if (current.prev != null && current.next == null) {//End of list
					current.prev.next = null;
					current = null;
				}
			}
			gotoNext();
		}
	}
	
	public boolean hasMore() {
		return current != null;
	}
	
	public boolean contains(double aDouble) {
		reset();
		while(current != null) {
			if(current.data == aDouble) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
}





