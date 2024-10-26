public class Tubes {
	private String id;
	private double radius;
	private double height;
	
	//Default constructor
	public Tubes() {
		this.id = "none";
		this.radius = 0.0;
		this.height = 0.0;
	}
	
	//Param constructor
	public Tubes(String aID, double aRadius, double aHeight) {
		this.setID(aID);
		this.setRadius(aRadius);
		this.setHeight(aHeight);
	}
	
	//Accessors
	public String getID() {
		return this.id;
	}

	public double getRadius() {
		return this.radius;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	//Mutators
	public void setID(String aID) {
		if(aID != null) {
			this.id = aID;
		}
		else {
			this.id = "none";
		}
	}

	public void setRadius(double aRadius) {
		if(aRadius >= 0.0) {
			this.radius = aRadius;
		}
		else {
			this.radius = 0.0;
		}
	}
	
	public void setHeight(double aHeight) {
		if(aHeight >= 0.0) {
			this.height = aHeight;
		}
		else {
			this.height = 0.0;
		}
	}
	public String toString() {
		return "Tube ID: "+this.id+" Tube Radius: "+this.radius+" Tube Height: "+this.height;
	}
	
	
	public boolean equals(Tubes aTube) {
		return aTube != null &&
				this.id.equals(aTube.getID()) &&
				this.radius == aTube.getRadius() &&
				this.height == aTube.getHeight();
	}
}