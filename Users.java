package main;
import javax.swing.*;
import java.io.*;


public class Users {
	
	   protected String[] userName = new String[100];
	   protected String[] userSurname= new String[100];
	   protected int[] userAge= new int[100];
	   protected int[] userType= new int[100];
	   protected int numberOfUsers = 0;
	   
	   // constructor
	   public Users(String[] startUserName, String[] startUserSurname, int[] startUserAge, int[] startUserType, int startNumberOfUsers)
	   {
		userName= new String[100];
		userSurname=new String [100];
		userAge=new int[100];
		userType=new int[100];
		numberOfUsers=0;
	   }
	   
	   public void AddUser() throws IOException{
		   //System.out.println ("Introduce the name of the user: ");
		   //BufferedReader entr1 =new BufferedReader (new InputStreamReader(System.in));
		   //String input1 = entr1.readLine();
		   //System.out.println(userName[0]);
	       //userName[numberOfUsers] = input1;
		   //System.out.println (userName[numberOfUsers]);

		   String input = JOptionPane.showInputDialog("Introduce the name of the user:");
	       userName[numberOfUsers] = input;
		   input = JOptionPane.showInputDialog("Introduce the surname of the user:");
	       userSurname[numberOfUsers] = input;
		   input = JOptionPane.showInputDialog("Introduce the age of the user:");
		   userAge[numberOfUsers] = Integer.parseInt(input);
		   
		   do{
			   input = JOptionPane.showInputDialog("Introduce the type of the user:\n1.Waiter\n2.Manager\n3.Client");
			   userType[numberOfUsers] = Integer.parseInt(input);
		   }	while	   ((userType[numberOfUsers]<1)||(userType[numberOfUsers]>3));
	       
		   numberOfUsers++;
	   }
	   
	   public void AddUser(int clientType) throws IOException{
		   //System.out.println ("Introduce the name of the user: ");
		   //BufferedReader entr1 =new BufferedReader (new InputStreamReader(System.in));
		   //String input1 = entr1.readLine();
		   //System.out.println(userName[0]);
	       //userName[numberOfUsers] = input1;
		   //System.out.println (userName[numberOfUsers]);

		   String input = JOptionPane.showInputDialog("Introduce the name of the user:");
	       userName[numberOfUsers] = input;
		   input = JOptionPane.showInputDialog("Introduce the surname of the user:");
	       userSurname[numberOfUsers] = input;
		   input = JOptionPane.showInputDialog("Introduce the age of the user:");
		   userAge[numberOfUsers] = Integer.parseInt(input);
		   userType[numberOfUsers] = clientType;
		   numberOfUsers++;
	   }
	   
	   public void ListUsers(){
	       /*
	        *'\n' = Enter, line break
	        * '\t' = Tab spacing
	        * 
	        * */
	       System.out.println("Name\t\tSurname\t\tAge\t\tType\t\tuserEmail\t\t\tuserAddress\n");
	       for(int i = 0; i < numberOfUsers; i++){
	    	   String firsttab = "\t\t";
	    	   String secondtab = "\t\t";
	           if(userName[i].length()>7)
	        	   firsttab = "\t";
	           if(userSurname[i].length()>7)
	        	   secondtab = "\t";
	           
	           System.out.println(userName[i]+firsttab+userSurname[i]+secondtab+userAge[i]+"\t\t"+userType[i]+"\n");
	       }
	       System.out.println("Totalnumber:"+numberOfUsers);
	   }
}
