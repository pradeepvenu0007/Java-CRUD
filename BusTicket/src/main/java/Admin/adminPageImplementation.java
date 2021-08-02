package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

import DbConnection.DBUtil;
import Exception.tableNotFoundException;

public class adminPageImplementation {
	
	public void delete() throws Exception
	{
		Scanner ip=new Scanner(System.in);
		Connection con=DBUtil.getConnection();
		 String query="Drop table ";
		 System.out.println("Enter the Name of the Bus route to be Deleted");
		 query=query.concat(ip.next());
		 Statement deleteQuery=con.createStatement();
		 try {
		 deleteQuery.executeUpdate(query);
		 
			 System.out.println("Bus Route Deleted Successfully");
			 System.out.println("Info: Press any key to acknowledge");
			 ip.nextLine();
		 }
		 catch(SQLSyntaxErrorException e) 
		 {
			 throw new tableNotFoundException();
			 
		 }
		 
	}
	
	public void changeFare() throws Exception
	{
		 Scanner ip=new Scanner(System.in);
		 Connection con=DBUtil.getConnection();
		 System.out.println("Enter the Stage No. for which fare is to be changed");
		 int Stage=ip.nextInt();
		 System.out.println("Enter the changed fare for which fare is to be changed");
		 int fare=ip.nextInt();
		 PreparedStatement FareChangeQuery=con.prepareStatement("update fareTableOrdinary set fare=? where stage=?");
		 FareChangeQuery.setInt(1,fare);
		 FareChangeQuery.setInt(2,Stage);
		 try {
		 FareChangeQuery.executeUpdate();
		 System.out.println("\nInfo: Press c to continue changing fare \n Press any key to return admin mode");
		 String choice=ip.nextLine();
		 switch(choice)
		 {
		 	case "c":
		 		changeFare();
		 		
		 }
		 }
		 catch(SQLSyntaxErrorException e)
		 {
			 System.out.println("Stage don't exists try with lesser stage");
		 }
		 
	}


	public void addroute() throws Exception
	{
		Scanner ip=new Scanner(System.in);
		Connection con=DBUtil.getConnection();//getConnection("jdbc:mysql://127.0.0.1:3306/Project0","root","admin");
		System.out.println("Enter the name of the bus route:");
		String BusRoutename=ip.next();
		String query="create table ";
		query=query.concat(BusRoutename).concat(" (Stage int unique,Name varchar(20))");
		System.out.println(query);
		Statement createTable=con.createStatement();
		try{
			createTable.execute(query);
			System.out.println("Enter Total no. of stages in bus route");
			int total=ip.nextInt();
			String StageAddQuery="insert into ";
			StageAddQuery=StageAddQuery.concat(BusRoutename).concat(" values (?,?)");
			PreparedStatement insertQuery=con.prepareStatement(StageAddQuery);
			while(total!=0)
			{
				System.out.println("Enter Stage No. :");
				//int stageNum=ip.nextInt();
				insertQuery.setInt(1, ip.nextInt());
				ip.nextLine();
				System.out.println("Enter stage name :");
				//String stageName= ip.nextLine();
				
				
				insertQuery.setString(2,ip.nextLine());
				insertQuery.addBatch();
			total--;
		}
			insertQuery.executeBatch();
			System.out.println("Added successfully \n");
		}
		catch(SQLSyntaxErrorException e)
		{
			throw new tableNotFoundException();
			
		}
		
			
	}

}
