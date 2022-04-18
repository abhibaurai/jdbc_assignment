package day4JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {

	Connection con;
	Statement stat;
	int book_id;
	String book_name;
	PreparedStatement pre;
	
	
	public Insert()


	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
			System.out.println("Database Connected....");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter book id.");
			customer_id=sc.nextInt();
			System.out.println("Enter book name");
			customer_fname=sc.next();
			System.out.println("Enter customer last name");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

		public void insertPreStatement(){
		try
		{
			pre=con.prepareStatement("insert into library values(?,?)");
			pre.setInt(1,bookr_id);
			pre.setString(2,book_name);
			System.out.println(book_id+"   "+book_name);
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Record Inserted...");
			else
				System.out.println("Record Not Inserted...");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	


}
