package main;
import java.io.IOException;

import javax.swing.*;

public class WebUsers extends Users{

	   private String[] userEmail = new String[100];
	   private String[] userAddress= new String[100];
	   
	   // constructor
	   public WebUsers(String[] startUserName, String[] startUserSurname, int[] startUserAge, int[] startUserType, int startNumberOfUsers, String[] startUserEmail, String[] startUserAddress)
	   {
		   super(startUserName,startUserSurname,startUserAge,startUserType,startNumberOfUsers);
		   userEmail=new String[100];
		   userAddress=new String[100];
	   }
	   
	   public void AddWebUser() throws IOException{
		   this.AddUser(3);
		   String input;
		   input = JOptionPane.showInputDialog("Introduce the email of the user:");
	       userEmail[numberOfUsers -1] = input;
		   input = JOptionPane.showInputDialog("Introduce the delivery address of the user:");
	       userAddress[numberOfUsers-1] = input;
	   }
	   
	   public void printUserDetails(int userID){
		   System.out.println("\nName of the User: " + userName[userID]+ " " + userSurname[userID]);
		   System.out.println("\nEmail-Address: " + userEmail[userID]);
		   System.out.println("\nDelivery Address: " + userAddress[userID] + "\n");
	   }
	   
	   public void ListWebUsers(){
	       /*
	        *'\n' = Enter, line break
	        * '\t' = Tab spacing
	        * 
	        * */
	       /*System.out.println("Name\t\tSurname\t\tAge\t\tType\t\tuserEmail\t\tuserAddress\n");
	       for(int i = 0; i < getNumberOfUsers(); i++){
	           
	            System.out.println(getUserName(getNumberOfUsers())+"\t\t"+getUserSurname(getNumberOfUsers())+"\t\t"+getUserAge(getNumberOfUsers())+"\t\t"+getUserType(getNumberOfUsers())+"\t\t"+userEmail[getNumberOfUsers()]+"\t\t"+userAddress[getNumberOfUsers()]+"\n");
	       }*/
	       //System.out.println("ID\t\tName\t\tSurname\t\tAge\t\tType\t\tuserEmail\t\tuserAddress\n");
	       for(int i = 0; i < numberOfUsers; i++){
	    	   String firsttab = "\t\t";
	    	   String secondtab = "\t\t";
	           if(userName[i].length()>7)
	        	   firsttab = "\t";
	           if(userSurname[i].length()>7)
	        	   secondtab = "\t";

	            System.out.println(i+"\t\t"+userName[i]+firsttab+userSurname[i]+secondtab+userAge[i]+"\t\t"+userType[i]+"\t\t"+userEmail[i]+"\t\t"+userAddress[i]+"\n");
	       }
	   }
}
