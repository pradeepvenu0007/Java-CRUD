package User;


import java.util.Scanner;

import org.apache.log4j.Logger;


import homepage.Home;

public class UserMode {
	public void usermodeoptions() throws Exception
	{
		Logger logger = Logger.getLogger("AdminPage.class");
		userPageImplementation user=new userPageImplementation();
		System.out.println("\n***********************************User Mode ******************************\n1. View Bus Route chart\n2. View Ticket\n3. View All Bus Route\n4. Back Menu\nPress any to exit");
		Scanner ip=new Scanner(System.in);
		String choice=ip.next();
		switch (choice) 
		{
		case "1":
			logger.info("User optioned to view a bus route");
			user.display();
			usermodeoptions();
			break;
		case "2":
			logger.info("user willing to find the ticket price");
					
					System.out.println("*************************************************************************View Ticket Mode***************************************************************");
					user.issueTicket();
					usermodeoptions();
					break;
		case "3":
			logger.info("user willing to view all bus route");
			
			user.displayTable();
			usermodeoptions();
			break;
		case "4":
			logger.info("user redirected back to home page");
			Home home=new Home();
			home.homepPageOptions();
			break;
		default:
			System.out.println("Thank you for Using the Application....Hava a Nice Day :)");
					}
		
	}
}
