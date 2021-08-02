package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;
import DbConnection.DBUtil;
import Exception.tableNotFoundException;

public class userPageImplementation extends viewTable {
	public void displayTable() throws Exception 
	{
		Connection con=DBUtil.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("show tables");
		System.out.println("\nAll Bus Route Availabe\n");
		while(rs.next()) {
			if(!rs.getString(1).equals("faretableordinary"))
			System.out.println(rs.getString(1));
		}
		
		Acknowledge();
	}
	
 public String display() throws Exception 
 {
	
		System.out.println("Enter the route name:");
		Scanner ip=new Scanner(System.in);
		String Route=ip.next();

		Connection con=DBUtil.getConnection();
		 String query="select * from ";
		 query=query.concat(Route);
			//st.setString(1,"B55");
			PreparedStatement st=con.prepareStatement(query);
			try {
			ResultSet rs=st.executeQuery();
			System.out.println("\nStage No.\tStage Name\n");
			while(rs.next()) {
				
				System.out.println("    "+rs.getInt(1)+" \t\t "+rs.getString(2));
			
			}
			
			}
			catch(Exception e)
			{
				throw new tableNotFoundException();
			}
			
			Acknowledge();
			return Route;
		
 }

 public void issueTicket() throws Exception
	{     Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Project0","root","admin");
		
		
		Scanner ip=new Scanner(System.in);
		
		
		String routeName=display();
		System.out.println("Enter the stage No. of Source:");
		int source=ip.nextInt();
		System.out.println("Enter the stage No. of Destination:");
		int destination=ip.nextInt();
		int stage=Math.abs(source-destination);
		System.out.println("Enter the No. of Person:");
		int Quantity=ip.nextInt();
		 PreparedStatement fare=con.prepareStatement("select fare from fareTableordinary where Stage=?");
		 fare.setInt(1,stage);
		 ResultSet fareprice=fare.executeQuery();
		 String query="select Name from ";
		 query=query.concat(routeName).concat(" where Stage in (").concat(String.valueOf(source)).concat(",").concat(String.valueOf(destination)).concat(")");
		 PreparedStatement Src_des=con.prepareStatement(query);
		// Src_des.setString(1,routeName);
		 //Src_des.setInt(1,source);
		 //Src_des.setInt(2,destination);
		 System.out.println(query);
		try { ResultSet SrcDes=Src_des.executeQuery();
		 SrcDes.next();
		
			 System.out.println("**********************Ticket Issued***************************\n");
			 System.out.println("Source:"+SrcDes.getString(1));
			 SrcDes.next();
			 System.out.println("Destination: "+SrcDes.getString(1));
		
		fareprice.next();
		System.out.println("Ticket Price:"+fareprice.getInt(1)+"*"+Quantity+"= Rs."+fareprice.getInt(1)*Quantity);
		System.out.println("\n**********************Happy Journey***************************\n");
		 Acknowledge();
		 ip.next();
				 
		}
		catch(SQLSyntaxErrorException e)
		{
			System.out.println("Sorry.Invaild Source/Destination");
		}
	}


}
