package ie.gmit.sw;

import java.util.Scanner;

public class Runner {
	
	//Private Variables
	private static long nGSize;
	private static String csvName;
	private static String fileDir;
	
	//Instance of menu
	private static Menu menu = new Menu();
	
	public static void main(String[] args) throws Exception {
		//Variables
		int selection = 0;
		
		//Print Menu
		menu.menuOptions();
		
		Scanner scanner = new Scanner(System.in);
		
		
		//Do Something depending on option picked
		while(selection != 5)
		{
			selection = scanner.nextInt();
			switch(selection) {
				case 1: 
					textFileDir();
					break;
				case 2: 
					nGramSize();
					break;
				case 3: 
					csvName();
					break;
				case 4: 
					Parser.parse(fileDir);
					break;
				case 5: 
					System.exit(0);
					break;
				default:
					break;
			}
		}
		
		//Create an instance of Process Meter 
		processMeter printMeter = new processMeter();
		printMeter.main();
	}
	
	//Get NGram Size
	public static void nGramSize()
	{
		//Variable for Do While
		boolean error;
		
		do {
			error = false;
			//Ask User to Enter Size of NGram they wish to use
			System.out.println("Please Enter Size of N-Gram Between 1-5");
			Scanner scanner = new Scanner(System.in);
			
			//Assign to variable
			nGSize = scanner.nextLong();
			
			if(nGSize > 5 || nGSize < 1)
			{
				System.out.println("Error! Number Entered outside of range!");
				error = true;
			}
		}while(error == true);
		
		//Return to Menu when Complete
		System.out.println("Done! Returning to Menu");
		menu.menuOptions();
	}
	
	//Send NGram Size to Parser
	public static long getNGramSize()
	{
		return nGSize;
	}

	//Ask User for CSV File Name and Directory
	public static void csvName()
	{
		//Ask User to Enter Size of NGram they wish to use
		System.out.println("Please Enter Name for CSV File");
		Scanner scanner = new Scanner(System.in);
		
		//Assign to variable
		csvName = scanner.next();
		
		//Ask User where to store File
		System.out.println("Please enter a directory for file");
		
		//Assign Variable
		fileDir = scanner.next();
		
		//Return to Menu when Complete
		System.out.println("Done! Returning to Menu");
		menu.menuOptions();
	}
	
	//Send File Name to Parser
	public static String getCSVName()
	{
		return csvName;
	}
	
	//Get Text File Directory
	public static void textFileDir() throws Exception
	{
		//Ask User to Enter Size of NGram they wish to use
		System.out.println("Please Enter Full Directory for Text Files");
		System.out.println("***include / at end****");
		Scanner scanner = new Scanner(System.in);
		
		//Assign to variable
		fileDir = scanner.next();
		
		//Return to Menu when Complete
		System.out.println("Done! Returning to Menu");
		menu.menuOptions();
	}
	
	//Send File Dir to Parser
	public static String getDirectory()
	{
		return fileDir;
	}
}