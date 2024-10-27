import java.util.Scanner;

public class SortingFE {
	//Size can be changed depending on the expected amount of Strings needing to be sorted
	private static int SIZE = 15;
	private static Scanner keyboard = new Scanner(System.in);
	
	static sortStrings[] sortStrings = new sortStrings[SIZE];
	
	public static void main(String[] args) {
		
		boolean runAgain = true;
		while(runAgain == true) {
		System.out.println("Enter any number of strings and I will sort by SORT’s. " 
				+ "Once you’re done entering sentences enter “quit”.");
		System.out.println();
		boolean quit = false;
		
		//Initialize sortStrings array
		for (int i = 0; i < SIZE; i++) {
		    sortStrings[i] = new sortStrings(); // Initialize each element
		}
		
		//Storing strings
		int index = 0;
		while(quit == false) {
			String temp = keyboard.nextLine();
			//System.out.println(temp);
			if(temp.equalsIgnoreCase("quit"))
				quit = true;
			else {
				sortStrings[index].setString(temp);
//				strings[index] = temp;
				index++;
			}
		}
		
		//Assigning a value for the amount of sorts in each string
		for(int i = 0; i < SIZE; i++) {
		
			String temp = sortStrings[i].getString();
			sortStrings[i].setSorts(countSorts(temp)); 
			
		//Check for proper storing of #ofSorts
			//System.out.println(sortStrings[i].getSorts());
		}

		mergeSort(sortStrings);
		
		//Prints out sort sorted array
		System.out.println("sort SORTED!");
		for (int i = 0; i < SIZE; i++) {
		    if(sortStrings[i].getString() != null) {
		    	System.out.println(sortStrings[i].getString());
		    	//System.out.println(sortStrings[i].getSorts());
		    	//System.out.println();
		    }
		}
			System.out.println();
			System.out.println("Would you like to sort more Strings?");
			String playAgain = keyboard.nextLine();
			if(playAgain.equalsIgnoreCase("no")) {
				System.out.println("Goodbye!");
				runAgain = false;
			}
			System.out.println();
		}
	}

	//Merge sort based upon numOfSorts value for index i
	public static void mergeSort(sortStrings[] a ) {
		int size = a.length;
		if(size < 2) //Halting condition
			return;
		
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		//Splitting the intial array into 2
		sortStrings[] left = new sortStrings[leftSize];
	    sortStrings[] right = new sortStrings[rightSize];
		
		//Passing data to new arrays
		for(int i = 0; i < mid; i++) 
			left[i] = a[i];
		for(int i = mid; i < size; i++) 
			right[i-mid] = a[i];
		
		mergeSort(left); //Recursive Call
		mergeSort(right); //Recursive Call
		merge(left,right,a);
	}
	
	public static void merge(sortStrings[] left, sortStrings[] right, sortStrings[] a) {
		int leftSize = left.length;
		int rightSize = right.length;
		
		int i = 0; //Left Index
		int j = 0; //Right Index
		int k = 0; //Merged array a's index
		
		while(i < leftSize && j < rightSize) {
			if (left[i].getSorts() <= right[j].getSorts()) {
	            a[k] = left[i];
	            i++;
	        } else {
	            a[k] = right[j];
	            j++;
	        }
	        k++;
		}
		
		//Left Overs
		while(i < leftSize) {
		 a[k] = left[i];
		    i++;
		    k++;
		}
		while(j < rightSize) {
			a[k] = right[j];
	        j++;
	        k++;
		}
	}
	
	public static int countSorts(String str) {
		int count = 0;
		if(str != null) {
		int index = str.toLowerCase().indexOf("sort");
		while(index != -1) {
			count++;
			index = str.toLowerCase().indexOf("sort", index + 1);
			}
		}
		return count;
	}
}
