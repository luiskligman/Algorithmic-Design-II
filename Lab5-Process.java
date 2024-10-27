public class Process {

	private String name;
	private double completionTime;
	
	//Default constructor
	public Process() {
		this.name = "none";
		this.completionTime = 0.0;
	}
	
	//Param constructor
	public Process(String aName, double aCompletionTime) {
		this.setName(aName);
		this.setCompletionTime(aCompletionTime);
	}
	
	//Accessors
	public String getName() {
		return this.name;
	}

	public double getCompletionTime() {
		return this.completionTime;
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

	public void setCompletionTime(double aCompletionTime) {
		if(aCompletionTime >= 0.0) {
			this.completionTime = aCompletionTime;
		}
		else {
			this.completionTime = 0.0;
		}
	}
	//To String
	public String toString() {
		return "Process Name: "+this.name+" Completion Time: "+this.completionTime;
	}
}