package main;

public class Menu {

	private String[] dishNames = new String[100];
	private double[] dishPrices= new double[100];
	private int[] dishPreparationTimes= new int[100];
	private String[] dishDescriptions= new String[100];
	private int numberOfDishes = 0;
	
	// constructor
	public Menu(String[] startDishNames, double[] startDishPrices, int[] startDishPreparationTimes, String[] startDishDescriptions, int startNumberOfDishes)
	{
		dishNames=new String[100];
		dishPrices=new double[100];
		dishPreparationTimes=new int[100];
		dishDescriptions=new String[100];
		numberOfDishes=0;
	}
	   
	public void AddDish(String name, double price, int preparationTime, String description){
		
		dishNames[numberOfDishes] = name;
		dishPrices[numberOfDishes] = price;
		dishPreparationTimes[numberOfDishes] = preparationTime;
		dishDescriptions[numberOfDishes] = description;
		numberOfDishes++;
	}
	
	public void ListDishes(){
		/*
		 *'\n' = Enter, line break
		 * '\t' = Tab spacing
		 * 
		 * */
		System.out.println("Name\t\tPrice\t\tPrep. time\tDescription\n");
		for(int i = 0; i < numberOfDishes; i++){
			
			System.out.println(dishNames[i]+"\t\t"+dishPrices[i]+"\t\t"+dishPreparationTimes[i]+"\t\t"+dishDescriptions[i]+"\n");
		}
		
	}
	
	public String getDishName(int num){
		return dishNames[num];
	}

	public double getDishPrice(int num){
		return dishPrices[num];
	}
	
	public int getNumberOfDishes(){
		return numberOfDishes;
	}

}
