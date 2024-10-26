import java.util.Scanner;
import java.io.*;

public class FileIOSolutions {
	public static Tubes[] tubes;
	public static String[] words;
	public static final String DELIM = "\t";
	public static final int TUBE_FIELD_AMT = 3;
	
	public static void pastTense(String ItIs, String ItWas) {
		words = new String[43];
		readItIsFile(ItIs);
		
		System.out.println("Printing words"); //Prints out the array words[]
		for(int j = 0; j < words.length; j++) {
			System.out.println(words[j]);
		}
		
		isToWas();
		System.out.println("Printing past tense words"); //Prints out the array words[]
		for(int j = 0; j < words.length; j++) {
			System.out.println(words[j]);
		}
		writeItWasFile(ItWas);
	}
	public static void readItIsFile(String aName) { //Reads each word and saves it to words[i]
		try {
			
			Scanner fileScanner = new Scanner(new File(aName));
			String fileLine = ""; 
			
			int i = 0;
			while(fileScanner.hasNext()) { 
				 fileLine = fileScanner.next(); //Reads each word
				 words[i] = fileLine; //Saving each word "fileLine" to words[i]
				 i++;
			}
			fileScanner.close(); //Stops the scanning
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public static void writeItWasFile(String aName) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			//Body
			for(int i = 0; i < words.length; i++) {
				if(words[i] == null)
					break;
				fileWriter.println(words[i]);
			}
			fileWriter.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void isToWas() { //Changes all instances of is to was in the words array
		for(int i = 0; i < words.length; i++) {
			if(words[i].equalsIgnoreCase("is")) {
				words[i] = "was";
			}
		}
	}
	
	public static double totalTubeVolume(String aFile) {
		tubes = new Tubes[24];
		readTubesFile(aFile);
		double volume = calculateVolume();
		return volume;
	}
	public static float calculateVolume() {
		float volume = 0;
		for(int i = 0; i < tubes.length; i++) {
			volume += Math.PI * tubes[i].getHeight() * tubes[i].getRadius() * tubes[i].getRadius();
			//System.out.println(tubes[i].getRadius());
		}
		//System.out.println(volume);
		return volume;
	}
	
	public static void readTubesFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));

			String fileLine = fileScanner.nextLine();//Read the line
			String[] splitLines = fileLine.split(DELIM);//Split the line

			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine(); //read the line
				splitLines = fileLine.split(DELIM); //Split the line
				if(splitLines.length == TUBE_FIELD_AMT) { //check the line
					//Process - create a taco and add it to the array
					String id = splitLines[0];
					double radius = Double.parseDouble(splitLines[1]);
					double height = Double.parseDouble(splitLines[2]);
					Tubes aTube = new Tubes(id, radius, height);
					FileIOSolutions.addTube(aTube);
				}
			}
			fileScanner.close(); //Do not forget this
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addTube(Tubes aTube) {
		if(tubes[tubes.length-1] != null) {
			return;
		}
		for(int i = 0; i < tubes.length; i++) {
			if(tubes[i] == null) {
				tubes[i] = aTube;
				break;
			}
		}
	}
}
