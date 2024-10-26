public class GroceryList {
	
	private GenLL<GroceryItem> groceries;
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 3;
	public static final int HEADER_FIELD_AMT = 2;
	
	public GroceryList() {
		groceries = new GenLL<GroceryItem>();
	}

	public void addItem(GroceryItem aGrocery) {
		if(aGrocery == null)
			return;
		
		groceries.add(aGrocery);
		
	}
	public void removeGrocery(String aName) {
		
		if(aName == null)
			return;
		
		groceries.reset();//Current = head
		while(groceries.hasMore()){//Current != null
			if(groceries.getCurrent().getName().equalsIgnoreCase(aName)) {
				groceries.removeCurrent();
				break;
			}
			groceries.gotoNext(); //current = current.link
		}
	
	}
	
	public double totalCost() {
		double total = 0;
		groceries.reset();
		while(groceries.hasMore()) {
			total += groceries.getCurrent().getValue();
			groceries.gotoNext();
		}
		return total;
	}
	
	public GroceryItem getCurrent() {
		return groceries.getCurrent();
	}
	
	public void removeCurrent() {
		groceries.removeCurrent();
	}
	
	public void gotoNext() {
		groceries.gotoNext();
	}
	
	public String contains(GroceryItem g) {
		
			//System.out.println("ConsoleName"+aConsoleName);
			String name = g.getName();
			double price = g.getValue();

			if(name == null) {
				return "false";
			}
			//System.out.println(gameName+" "+consoleName);
			
			groceries.reset(); //Sets current to head
			
			while(groceries.hasMore()) {
				//No WildCard
				if(groceries.getCurrent().getName().toLowerCase().contains(name.toLowerCase()) && 
						groceries.getCurrent().getValue() == price) {
					return "true";
				}
				groceries.gotoNext();
			}
			groceries.reset();
			return "false";
	}
	
	public void showList() {
		groceries.print();
	}
}