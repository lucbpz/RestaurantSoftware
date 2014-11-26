package main;
import javax.swing.*;

public class Orders {

	
	protected int[] orderedDishes = new int[100];
	protected int numberOfOrders = 0;
	
	//constructor
	public Orders(int[] startOrderedDishes, int startNumberOfOrders)
	{
		orderedDishes=new int[100];
		numberOfOrders=0;
	}
	
	public void AddOrder(Menu ourMenu){
		if (ourMenu.getNumberOfDishes()==0){
			System.out.println("There are no dishes in your menu.");
		}else{
			String input;
			int dish;
			do{
				   input = JOptionPane.showInputDialog("Which dish do you want to add to the order?\nIntroduce only the number of the dish:\n(In the menu there are "+ ourMenu.getNumberOfDishes() + " dishes in the menu.)");
				   dish = Integer.parseInt(input)-1;
			}	while(dish<0 || dish>=ourMenu.getNumberOfDishes());
	
			orderedDishes[numberOfOrders] = dish;
			numberOfOrders++;
		}
	}
	
	public void showOrders(Menu ourMenu){
		if(numberOfOrders!=0)
		{
			System.out.println("Name\n");
			for(int i = 0; i < numberOfOrders; i++)
				System.out.println(ourMenu.getDishName(orderedDishes[i])+"\n");
		}
		else
			System.out.println("There aren't any orders, please order something :)\n");
	}
	
	public void showTotalBill(Menu ourMenu){

		double price = 0;
		System.out.println("Name\t\tPrice\n");
		for(int i = 0; i < numberOfOrders; i++){
			
			System.out.println(ourMenu.getDishName(orderedDishes[i])+"\t\t"+ourMenu.getDishPrice(orderedDishes[i])+"\n");
			price=ourMenu.getDishPrice(orderedDishes[i])+price;
		}
		System.out.printf("\n\nThe total bill is:  %.2f \n\n",price);
	}
	
	public void payBill(Menu ourMenu){
		
		showTotalBill(ourMenu);
		int input = JOptionPane.showConfirmDialog(null, "Do you want to pay the bill and delete all the orders?");

		if(input==0)
		{
			for (int i=0; i<numberOfOrders;i++){
				orderedDishes[i]=0;
			}
			numberOfOrders=0;
		}

	}

	protected int getNumberOfOrders() {
		return numberOfOrders;
	}
	
	protected int[] getOrderedDishes() {
		return orderedDishes;
	}
}
