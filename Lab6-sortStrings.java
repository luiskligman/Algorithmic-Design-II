public class sortStrings {
	private String string;
	private int numOfSorts;
	
	//Default Constructor
	public sortStrings() {
		this.string = null;	
		this.numOfSorts = 0;
	}
	
	//Param Constructor
	public sortStrings(String aString, int Sorts) {
		this.setString(aString);
		this.setSorts(Sorts);
	}

	//Accessors
	public String getString() {
		return this.string;
	}
	public int getSorts() {
		return this.numOfSorts;
	}
	
	//Mutators
	public void setString(String aString) {
		if(aString != null) {
			this.string = aString;
		}
	}
	public void setSorts(int sorts) {
		this.numOfSorts = sorts;
	}
	
	public String toString() {
		return this.string+" "+this.numOfSorts;
	}
}
