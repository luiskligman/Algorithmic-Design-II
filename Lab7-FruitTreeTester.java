import java.util.Scanner;
import java.io.File;

public class FruitTreeTester {

	private static final String DELIM = "\t";
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Creates instance of LinkedBSTree of Fruit
		LinkedBST<Fruit> iBST = new LinkedBST<Fruit>();
		
		System.out.println("Welcome to the fruit tree!");
		//Prompting the user for a file name
		System.out.println("Please enter a Fruit File Name");
		String fileName = keyboard.nextLine();
		readFile(fileName, iBST);
		System.out.println("Populating tree file");
		
		//Printing in-order traversal
		System.out.println("Printing the in-order traversal");
		iBST.printInorder();
		System.out.println();
		
		//Printing the pre-order traversal
		System.out.println("Printing the pre-order traversal");
		iBST.printPreorder();
		System.out.println();
		
		//Printing the post-order traversal
		System.out.println("Printing the post-order traversal");
		iBST.printPostorder();
		System.out.println();
		
		//Removing object from Binary Search Tree
		System.out.println("Deleting Apple     0.4859853412170728");
		Fruit aFruit = new Fruit("Apple", 0.4859853412170728);
		iBST.remove(aFruit);
		//Printing in-order traversal
		System.out.println("Printing the in-order traversal");
		iBST.printInorder();
		System.out.println();
		
	}
	
	//Reads file and stores values as objects being "fruit" in a Binary Search Tree
	public static void readFile(String aFileName, LinkedBST<Fruit> iBST) {
		try {
			Scanner fileScanner = new Scanner(new File(aFileName));
			//Read
			while(fileScanner.hasNextLine()) {
				String fileLine =  fileScanner.nextLine(); //Read the line
				String[] splitLine = fileLine.split(DELIM); //Split the line
				if(splitLine.length == 2) {
					String type = splitLine[0];
					double weight = Double.parseDouble(splitLine[1]);
					
					//Create new fruit "object" and add it
					Fruit aFruit = new Fruit(type, weight);
					iBST.add(aFruit);
				}
			}
			fileScanner.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
