package main;
import javax.swing.*;

public class WebMenu extends Menu{

	private String[][] review = new String[100][100];
	private int[] numberReviews = new int [100];
	private int[][] rating = new int [100][100];
	private int[] numberRatings = new int [100];

	// constructor
	public WebMenu(String[] startDishNames, double[] startDishPrices, int[] startDishPreparationTimes, String[] startDishDescriptions, int startNumberOfDishes, String[][] startReview, int[] startNumberReviews, int[][] startRating, int[] startNumberRatings)
	{
		super(startDishNames,startDishPrices,startDishPreparationTimes,startDishDescriptions,startNumberOfDishes);
		review=new String[100][100];
		numberReviews=new int [100];
		rating=new int [100][100];
		numberRatings=new int [100];
	   }
	
		   
	public void addReview(){
		if (getNumberOfDishes()==0){
				System.out.println("Your restraunt does not have any dishes yet that you could write a review for.");
		} else{
			String input; 
			int dishNumber;
			   do{
				   input = JOptionPane.showInputDialog("Which dish do you want to write a review for?\n(At the moment there are " + getNumberOfDishes() + " to write a review for.)");
				   dishNumber = Integer.parseInt(input);
			   }	while(dishNumber<=0 || dishNumber>getNumberOfDishes());

					
			input = JOptionPane.showInputDialog("Introduce a review:");
			review[dishNumber-1][numberReviews[dishNumber-1]] = input;
			numberReviews[dishNumber-1]++;
		} 

		
	}
	
	public void rateDish(){
		if (getNumberOfDishes()==0){
			System.out.println("Your restraunt does not have any dishes yet that you could rate.");
		} else{
			String input;
			int dishNumber;
			   do{
				   input = JOptionPane.showInputDialog("Which dish do you want to rate?\n(At the moment there are " + getNumberOfDishes() + " to rate.)");
				   dishNumber = Integer.parseInt(input);
			   }	while(dishNumber<=0 || dishNumber>getNumberOfDishes());
				
			input = JOptionPane.showInputDialog("Put numbers from 1 to 5 to rate the dish (5 is best, 1 is worst):");
			int ratingValue = Integer.parseInt(input);

			rating[dishNumber-1][numberRatings[dishNumber-1]] = ratingValue;
			numberRatings[dishNumber-1]++;
		}
	}
	
	public void showReviews(){
		
		String input = JOptionPane.showInputDialog("Of which dish do you want to see the reviews?\n");
		int dishNumber = Integer.parseInt(input);
		
		if (numberReviews[dishNumber-1] == 0){
			System.out.println("There are no reviews for this dish.");
		}else{
			System.out.println("Name:"+getDishName(dishNumber-1)+"\nReviews:");

			for(int i=0;i<numberReviews[dishNumber-1];i++)
				System.out.println((i+1)+") "+review[dishNumber-1][i]+"\n\t");
		}
	}
	
	public void showRatings(){
		
		String input = JOptionPane.showInputDialog("Of which dish do you want to see the ratings?");
		int dishNumber = Integer.parseInt(input);
		
		if (numberRatings[dishNumber-1] == 0){
			System.out.println("There are no ratings for this dish.");
		}else{
			System.out.println("Name:"+getDishName(dishNumber-1)+"\nRatings:");

			for(int i=0;i<numberRatings[dishNumber-1];i++)
				System.out.println((i+1)+") "+rating[dishNumber-1][i]+"\n");
		}
	}	

}
