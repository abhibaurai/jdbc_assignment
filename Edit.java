package day4JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Edit {
	Connection con;
	Statement stat;
	int book_id;
	String book_name;
	PreparedStatement pre;



public Edit()
{
	try
	{

		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "abhi");
		System.out.println("Database Connected....");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter book id.");
		book_id=sc.nextInt();
		System.out.println("Enter book name");
		book_name=sc.next();
	
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
	public void editPreStatement(){
	try
	{
		System.out.println("heyy");
		pre=con.prepareStatement("update library set book_name=?, book_id=?");
		
		pre.setString(1,book_name);
		pre.setInt(5,book_id);
		
		int ra=pre.executeUpdate();
		if(ra>0)
			System.out.println("Record updated for id = "+book_id);
		else
			System.out.println("Record is not updated..");
		pre.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}