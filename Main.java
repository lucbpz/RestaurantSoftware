package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		
		//Scanner object to read options
		Scanner readerStr = new Scanner(System.in);
		Scanner readerInt = new Scanner(System.in);
		
		//Main objects so that we always work with the same and we don't the information
		Menu objMenu = new Menu(null,null,null,null,0);
		WebMenu objWebMenu = new WebMenu(null,null,null,null,0,null,null,null,null);
		Users objUsers = new Users(null,null,null,null,0);//User object to store all the users
		WebUsers objWebUsers = new WebUsers(null,null,null,null,0,null,null);
		Orders objOrders = new Orders(null,0);//Order Object to store all the orders
		WebOrders objWebOrders = new WebOrders(null,0,0);		
		
		int opcionMenu = 0;
		int opcionSubmenu = 0;
		
		//Show the main menu
		do{
			//Show title
			System.out.println("Welcome to my restaurant");
			
			//Show main options
			System.out.println("1) Manage users");
			System.out.println("2) Manage food menu");
			System.out.println("3) Manage orders");
			System.out.println("4) Exit");
			
			//Select an option text
			System.out.println("Select an option: ");
			
			//Save the option in a variable.
			try{
				opcionMenu = readerInt.nextInt();
			}
			catch(InputMismatchException ex ){
				
				opcionMenu = 99;
			}
			
			switch(opcionMenu)
			{	
			
			case 1:	//Manage users				
					do
					{
						System.out.println("1) Add User");
						System.out.println("2) List Users");
						System.out.println("3) Add web user");
						System.out.println("4) Main menu");
						
						//Show select option text
						System.out.println("Select an option: ");
						
						//Save the option selected
						try{
							opcionSubmenu = readerInt.nextInt();
						}
						catch(InputMismatchException ex ){
							
							opcionSubmenu = 99;
						}
						
						switch(opcionSubmenu){
						
						case 1: objUsers.AddUser();
							break;
							
						case 2:objUsers.ListUsers();
								objWebUsers.ListWebUsers();
							break;
							
						case 3: objWebUsers.AddWebUser();
							break;
							
						case 4:
							System.out.println(BorraPantalla());
							break;	
							
						default:
							//Wrong option
							System.out.println("The selected option doesn't exist.");
							System.out.println("Pres any key to continue.");
							System.in.read();
							break;
						}
						
					}
					while(opcionSubmenu != 4);
			break;
			
			case 2: //Manage Food Menu
				do
				{
					System.out.println("1) Add Dish");
					System.out.println("2) List Dishes");
					System.out.println("3) Add Dish review"); 
					System.out.println("4) Rate dish"); 
					System.out.println("5) Show Dish Reviews"); 
					System.out.println("6) Show Ratings"); 
					System.out.println("7) Main menu");
					
					//Show select option text
					System.out.println("Select an option: ");
					
					//Save the option selected
					try{
						opcionSubmenu = readerInt.nextInt();
					}
					catch(InputMismatchException ex ){
						
						opcionSubmenu = 99;
					}
					
					switch(opcionSubmenu){
					
					case 1://Add Dish option selected
						System.out.println("Creating a new dish in the menu");
						System.out.println("Provide the follwing information:");
						
						System.out.println("Dish name");
						String dishName = readerStr.nextLine();
						
						System.out.println("Dish price");
						double dishPrice = readerInt.nextDouble();
						
						System.out.println("Dish preparation time (minutes, integers)");
						int dishTime = readerInt.nextInt();
						
						System.out.println("Dish description");
						String dishDesc = readerStr.nextLine();
						
						objMenu.AddDish(dishName, dishPrice, dishTime, dishDesc);
						objWebMenu.AddDish(dishName, dishPrice, dishTime, dishDesc);

						System.out.println("New dish added :)");
						System.out.println("Press enter to continue");
						System.in.read();
						
					break;
						
					case 2://List dishes option selected
						
						System.out.println("Dish List");
						objMenu.ListDishes();
						
						break;
						
					case 3:// Add Reviews
						objWebMenu.addReview();
						break;
					case 4:// Rate Dishes
						objWebMenu.rateDish();
						break;	
					case 5:// Show Dish Reviews
						objWebMenu.showReviews();
						break;	
					case 6:// Show Ratings
						objWebMenu.showRatings();
						break;	
						
					case 7:
						System.out.println(BorraPantalla());
						break;
						
					default:
						//Wrong option
						System.out.println("The selected option doesn't exist.");
						System.out.println("Pres any key to continue.");
						System.in.read();
						break;
					}
					
				}
				while(opcionSubmenu != 7);
				break;
				
			case 3: //Manage Orders
				
				do
				{
					System.out.println("1) Add Orders");
					System.out.println("2) List Orders");
					System.out.println("3) Show Total Bill"); 
					System.out.println("4) Pay Bill"); 
					System.out.println("5) Put Web Order"); 
					System.out.println("6) List Web Orders"); 
					System.out.println("7) Cancel Web Orders"); 
					System.out.println("8) Main menu");
					
					//Show select option text
					System.out.println("Select an option: ");
					
					//Save the option selected
					try{
						opcionSubmenu = readerInt.nextInt();
					}
					catch(InputMismatchException ex ){
						
						opcionSubmenu = 99;
					}
					
					switch(opcionSubmenu){
					
					case 1://Add orders option selected
						objMenu.ListDishes();
						objOrders.AddOrder(objMenu);

						System.out.println("New order added :)");
						System.out.println("Press enter to continue");
						System.in.read();
						
					break;
						
					case 2://List orders option selected
						objOrders.showOrders(objMenu);
						
						break;
						
					case 3:// Show Total Bill
						objOrders.showTotalBill(objMenu);
						break;
					case 4:// Pay Bill
						objOrders.payBill(objMenu);
						break;	
					case 5:// Put Web Order
						objMenu.ListDishes();
						objWebOrders.AddOrder(objMenu, objWebUsers);
						break;	
					case 6:// List Web Orders
						objWebOrders.showWebOrders(objMenu, objWebUsers);
						break;	
					case 7:// Cancel Web Orders
						objWebOrders.cancelOrders(objMenu);
						break;	
						
					case 8:
						System.out.println(BorraPantalla());
						break;
						
					default:
						//Wrong option
						System.out.println("The selected option doesn't exist.");
						System.out.println("Pres any key to continue.");
						System.in.read();
						break;
					}
					
				}
				while(opcionSubmenu != 8);
				break;
			case 4:
				System.out.println(BorraPantalla());
				System.out.println("Bye :)");
			break;	
				
			default:
				//Wrong option
				System.out.println("The selected option doesn't exist.");
				System.out.println("Pres any key to continue.");
				System.in.read();
			break;
			}//End switch sub menu users
			
		}//End main do
		while(opcionMenu != 4);	
	}
	
	static String BorraPantalla()
	{	
		String pantalla = "";
		
		for(int i= 0;i < 25; i++)
			{
				pantalla += "\n";
			}
			
		return pantalla;	
	}
}
