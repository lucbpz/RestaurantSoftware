package main;
import javax.swing.*;

public class WebOrders extends Orders{
	
	private int clientID = 0;

	// constructor
	public WebOrders(int[] startOrderedDishes, int startNumberOfOrders, int startClientID)
	   {
		   super(startOrderedDishes, startNumberOfOrders);
		   clientID = startClientID;

	   }

	// Add order for WebClient --> Name of WebClient
	public void AddOrder(Menu ourMenu, WebUsers ourUsers){
		String input;
		int dish;
		
		if (getNumberOfOrders()==0){ // in case no web order has been performed, no bill started
				
			ourUsers.ListWebUsers();
			
			do{
				   input = JOptionPane.showInputDialog("For which web client do you want to add a new dish to his orders?(Type in the ID of the user!)");
				   clientID = Integer.parseInt(input);
			}	while(clientID<0 || clientID>=ourUsers.numberOfUsers);
		}
		
		
		do{
			   input = JOptionPane.showInputDialog("Which dish do you want to add to the order?\nIntroduce only the number of the dish:\n(In the menu there are "+ ourMenu.getNumberOfDishes() + " dishes in the menu.)");
			   dish = Integer.parseInt(input)-1;
		}	while(dish<0 || dish>=ourMenu.getNumberOfDishes());

		orderedDishes[numberOfOrders] = dish;
		numberOfOrders++;
	}
	
	
	public void showWebOrders(Menu ourMenu,WebUsers ourUser){
		
		ourUser.printUserDetails(clientID);
		int[] orderedDishes = getOrderedDishes();
		for(int i = 0; i < getNumberOfOrders(); i++){
			
			System.out.println(ourMenu.getDishName(orderedDishes[i]));
			
		}
	}
	
	public void cancelOrders(Menu ourMenu){
		
		int input = JOptionPane.showConfirmDialog(null, "Do you want to delete all the orders?");

		if(input==0) {
			for(int i=0;i<numberOfOrders;i++){
				orderedDishes[i]=0;
			}
			numberOfOrders=0;
			clientID=0;
			
		}
			


	}

}
