
package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.OrderDao;
import com.revature.dao.TeddyDao;

public class Menu {
	//we need to instantiate the demo classes to use their methods in this class
		TeddyDao td = new TeddyDao();
		OrderDao od = new OrderDao();
		
		//All of the menu display options and control flow are contained in this method
		public void display() {
			
			boolean displayMenu = true; //this toggles whether the menu continues after user input
			Scanner scan = new Scanner(System.in); //Scanner object to parse user input		
			final Logger log = LogManager.getLogger(Menu.class);
			
			//greeting
			System.out.println("*====================================================*");
			System.out.println("Welcome to our Teddy Collection line  Application!");
			
			System.out.println("Please, start shopping");
			
			
			//display the menu options as long as displayMenu is true
			while(displayMenu) {
				
				System.out.println("----------------");
				System.out.println("CHOOSE AN OPTION");
				System.out.println("----------------");
				
				
				//menu options
				System.out.println("teddies -> show all teddies");
				System.out.println("add -> add a new teddy");
				System.out.println("changeteddycolors -> change colors to your preference"); //this is new as of Saturday - requires join!
				System.out.println("removeteddy -> remove purchased teddies");
				//System.out.println("orderbyid -> get all orders by id");
		        System.out.println("exit -> exit the application");
				
				
				//parse the user input after they choose a menu option, and move to the next line
				String input = scan.nextLine().toLowerCase();
				
				
				//switch statement that takes the user input, and does some logic depending on that input
				switch(input) {
				
				case "teddies": {
					log.info("User select all teddies");//general info log
					System.out.println("Please, start shopping by collecting all teddies.");

					//List of Employees that gets populated by the getTeddies method in our TeddyDemo
					List<Teddy> teddies = td.getTeddies(); 
					
					//Print out each teddy from the List one by one for the user to see
					for(Teddy t : teddies) {
						//a prettier way to return all employees (instead of relying on the toString method, seen in the other cases)
						//making use of a getter and String concatenation
						System.out.println(t.getTeddy_id() + ") " + t.getTeddy_name() + " " + t.getTeddy_colors() + t.getTeddy_description());
					}
					
					break;
				}
				
				
				case "add": {
					
					//we need to prompt the user for the employee's name, and their role id
					//we'll have to come up with some functionality to get the current date for the hire_date field
					System.out.println("Enter Teddy  Name:");
					String teddy_name = scan.nextLine();
					
					System.out.println("Enter Teddy Colors:");
					String teddy_colors = scan.nextLine();
					
					System.out.println("Enter teddy_description:");
					String teddy_description =scan.nextLine(); 
					
					Teddy newTeddy = new Teddy(teddy_name, teddy_colors, teddy_description);
					System.out.println(newTeddy);
					//Put the new teddy into the addTeddy() method in the EmployeeDao
					td.addTeddy(newTeddy);
					
					break;
				}
				
				case "changeteddycolors" : {
					
					System.out.println("Flip  colors menu to replace them with  your favorite one: ");
					
					//this is using the already existing getEmployees() method
					List<Teddy> teddies =td.getTeddies(); 
					
					
					//Print out each Employee from the List one by one for the user to see
					for(Teddy t : teddies) {
						System.out.println(t);
					}
					
					System.out.println("----------------------------------------------------");
					
					System.out.println("Enter the ID of the teddy whose colors are changing:");
					int idInput = scan.nextInt(); //the user enters the ID of the employee to change the role of
					scan.nextLine();
					
					System.out.println("Enter the new Colors  : 1)Yellow 2)Purple 3) 4)Spring green 5)Azure 6)Gray");
					int teddy_colorsInput = scan.nextInt();
					scan.nextLine();
					
					// teddy_colorsInput = teddyInput;
					td.changeTeddyColors(idInput, teddy_colorsInput); //to supply the user inputs as arguments to this DAO method
					
					break;
				}
				//to remove all purchased items
				case "removeteddy": {
					
					System.out.println("Please, delete all purchased teddies from the list");
					List<Teddy> teddies = td.getTeddies(); 
					
					//to print out each teddy from the List one by one for the user to see
					for(Teddy t : teddies) {
						System.out.println(t);
					}
					
					System.out.println("------------------------------");
					
					System.out.println("Enter the Id of purchased teddies to delete:");
					
					int idInput = scan.nextInt();
					scan.nextLine();
					
					if(idInput == 1) {
						System.out.println("can't delete it!!!");
						log.warn("User attempted to delete Charlotte");//log info
					} else {
						td.removeTeddy(idInput);		
					}
					
					break;
				}
				
				
				case "orderbyid":{
					System.out.println("Enter to get Order by Id");
					String orderInput = scan.nextLine();
					
					List<Order> orders = td.getOrdersById(orderInput);
					
					//get the list of order by id from dao
					for(Order o : orders) {
						
						//print them through loop
						System.out.print(o);
					}
					break;
				}
					
					
				case "exit": {
					System.out.println("Thank you for shopping");
					displayMenu = false;
					break;
				}
				
				default: {
					System.out.println("Oof! See you next time"); 
					break;
				}
				
					
				}
			}
		}

		//public void display() {
			// TODO Auto-generated method stub
			
		}



				
				
			
			
			
		
		
		
	











