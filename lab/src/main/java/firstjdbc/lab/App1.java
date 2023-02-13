package firstjdbc.lab;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App1 {
                                                                                                       
		public static void add() { // creating add method
			try 
			{
				//establish connection wit database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab", "root", "pooja@123");
				//  perform insertion operation 
				PreparedStatement st = con.prepareStatement("insert into library(bname,book_no) values (?,?)");
				Scanner sc = new Scanner(System.in); 
				System.out.println("enter a Book name"); // taking input from user
				String n = sc.nextLine();
				System.out.println("enter a Book Number");
				int a = sc.nextInt();

				st.setString(1, n);  // set the input data to the place of values
				st.setInt(2, a);
				st.executeUpdate();  // executing query
				System.out.println("Data entered Successfully");

				sc.close();					 // closing the scanner class
				con.close(); 				// closing the connection
			}
			catch (SQLException e)			// handling exception
			{ 

				e.printStackTrace(); // throwing exception 
			}
		}
		public static void update() 		// method to update in database
		{ 
			try
			{
				//establish connection with database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagement", "root", "root");
				// writing a sql statement to perform update operation 
				PreparedStatement st = con.prepareStatement("update library set bname=?,book_no=? where book_author=?");
				Scanner sc = new Scanner(System.in);
				System.out.println("enter a book name");// taking input from use which needs to update
				String n = sc.nextLine();
				System.out.println("enter a book Number");
				int a = sc.nextInt();
				System.out.println("enter a Book author");
				String b = sc.nextLine();


				st.setString(1, n);// set the input data to the place of values
				st.setInt(2, a);
				st.setString(1, b);// set the input data to the place of values

				st.executeUpdate();// executing query
				System.out.println("Data updated Successfully");
				sc.close();// closing the scanner class
				con.close();// closing the connection

			} 
			catch (SQLException e) 		 // handling exception

			{	
				e.printStackTrace(); // throwing exception 
			}
		}
		public static void delete() // method to delete in database
		{
			try
			{
				//establish connection with database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagement", "root", "root");

				// writing a sql statement to perform delete operation 
				PreparedStatement st = con.prepareStatement("delete from library where book_no=?");
				Scanner sc = new Scanner(System.in);

				System.out.println("enter a Book no");
				int no = sc.nextInt();			

				st.setInt(1, no);// set the input data to the place of values
				st.executeUpdate(); // executing query
				System.out.println("Data deleted Successfully");
				sc.close();
				con.close();

			} 
			catch (SQLException e) // handling exception
			{

				e.printStackTrace();// throwing exception
			}
		}
		public static void show_Library() { // method to print database
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagement", "root", "root");

				PreparedStatement st = con.prepareStatement("select * from library");
				ResultSet rs = st.executeQuery(); // executing query
		    	while(rs.next()) {
		    		System.out.println("Book_ID: "+rs.getInt(1)+" "+"Book_Name: "+rs.getString(2)+" "+"Book_author "+rs.getString(3));

		    	}
				con.close();
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}

		}
		public static void show_Book()   // method to choose a single book records
		{
			try
			{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagement", "root", "root");

				PreparedStatement st = con.prepareStatement("select * from library where book_no=?");
				Scanner sc = new Scanner(System.in);
				System.out.println("enter a book no to show a details");
				int no = sc.nextInt();
				st.setInt(1,no);
				ResultSet rs = st.executeQuery();

		    	if(rs.next()) {
		    		System.out.println("Book_No: "+rs.getInt(no)+" "+"Book_Name: "+rs.getString(2)+" "+"Book_Author: "+rs.getString(3));
		    	} else {
		    		System.out.println("Data not found!!");
		    	}

				sc.close();
				con.close();
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}

		}
	    public static void main( String[] args )
	    {
	    	System.out.println("Find Below Operation as per Given Number");

	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("1.add  2.Update  3.Delete  4.show-library   5.show-Book  6.Exit");
	    	int userInput = sc.nextInt(); // taking input from user

	    	switch(userInput) { // perform operation as per cases
	    	case 1: add(); // calling methods
	    	break;

	    	case 2: update();
	    	break;

	    	case 3: delete();
	    	break;

	    	case 4: show_Library();
	    	break;

	    	case 5: show_Book();
	    	break;

	    	default:
	        	if(userInput > 5) { 
	            System.out.println("Successfully Exited");
	        	} 
	        	else {
	            System.out.println("Invalid input");
	        	}
	        	break;   	

	    	}
	    	sc.close();    	
	}

}
