package com.revature.models;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.db.TeddyCollection;
import com.revature.db.TeddyCollectionInterface;
public class Menu {
	//Instantiate a LegoCollection object, so that we can use its methods.
		//We'll call different LegoCollection methods depending on what menu option the user chooses
		ArrayList<TeddyCollection> tc = new ArrayList<TeddyCollection>();
		//All of the menu display options and control flow are contained in this method
		//We'll call different methods that access our mock database depending on what option the user choose
		public void display() {
			
			boolean displayMenu = true; //this will toggle whether the menu options continue to display to the user 
			Scanner scan = new Scanner(System.in); //a Scanner object to parse user input
			
			//let's actually start construction the menu-----------
			
			//greet the user
			System.out.println("Welcome to our Teddy Collection Management Application!");
			System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
			System.out.println("*Please, start shopping*");

			
			//display the menu options as long as displayMenu is true
			while(displayMenu) {
				
				System.out.println("----------------");
				System.out.println("CHOOSE AN OPTION");
				System.out.println("----------------");
				
				
				//menu options (the thing the user can say -> the action it causes)
				System.out.println("Please-> Add to the basket");
				System.out.println("Please, enter your credentials -> ");
				System.out.println("TeddyById -> get a Teddy by its Id");
				System.out.println("addTeddy -> add a new Teddy");
				System.out.println("DelteTeddy -> delete sold Teddy");
				System.out.println("updateTeddy -> purchase new  Teddy");
				System.out.println("exit -> exit the application");
				
				//parse the user input after they ponder the menu options
				//.toLowerCase so the user doesn't have to worry about case-sensitivity
				String input = scan.nextLine().toLowerCase();
				
			
				//switch statement that will take the value of the user input, and execute the appropriate functionality
				//this is long ugly functionality... Better here than in the main method!
				switch(input) {
				
				case "hi": {
					System.out.println("Um... Hello?");
					break;
				}
				
				case "getallTeddies": {
					Teddy[] teddyArray = ((TeddyCollectionInterface) tc).getAllTeddies(); //get all LegoSets
					
					for(Teddy teddy : teddyArray) { //for every LegoSet we get in the Array...
						System.out.println(teddy); //print it out 
					}
					break;
				}
				
				case "teddybyid": {
					System.out.println("Enter a Teddy id to search for");
					int idInput = scan.nextInt(); //get the user's input for LegoSet Id
					scan.nextLine(); //we have to use .nextLine, since nextInt doesn't do it for us :/
					Teddy teddy = ((TeddyCollectionInterface) tc).getTeddyById(idInput); //find a LegoSet by id
					System.out.println(teddy); //print that teddy out to the user
					break;
				}
				
				case "addteddyName": {
					
					//get the user's input for the LegoSet pieces field
					System.out.println("Add  your favorite Teddy name to the  basket");
					int nameInput = scan.nextInt();
					scan.nextLine();
					break;
				}
				
                  case "addteddyColors": {
					
					//get the user's input for the LegoSet pieces field
					System.out.println("Add  your favorite Teddy color to the  basket");
					int colorsInput = scan.nextInt();
					scan.nextLine();
					break;
				}
                  case "addprice": {
              		
  					System.out.println("Choose your affordable price ");
  					int priceInput = scan.nextInt();
  					scan.nextLine();
  					break;
  				}
				
				case "updateteddy": {
					
					//get the user's input for the LegoSet franchise field
					System.out.println("Update your  to your favorite Teddy with price");
					String updateInput = scan.nextLine();
					break;
				}
					
                   case "deleteteddy": {
					
					System.out.println("All purchsed teddies were deleted");
					int deleteInput = scan.nextInt();
					scan.nextLine();
					break;
				}
				
				case "exit" : {
					System.out.println("Thank you for beeing loyal customer");
					displayMenu = false;
				}
				
				}
			}
		}
}
				
				
			
			
			


