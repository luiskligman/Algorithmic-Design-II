public interface DoubleLLInterface {
	public void gotoNext();
	public void gotoPrev();
	public void reset();
	public void gotoEnd();
	public boolean hasMore();
	
	public void setCurrent(double aDouble);
	public double getCurrent();
	
	public void add(double aDouble);
	public void addAfterCurrent(double aDouble);
	
	public void remove(double aDouble);
	public void removeCurrent();
	
	public void print();
	
	public boolean contains(double aDouble);
	
}
