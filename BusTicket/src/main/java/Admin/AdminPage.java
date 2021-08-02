package Admin;


import java.util.Scanner;

import org.apache.log4j.Logger;

import homepage.Home;

public class AdminPage {
	public void adminPageOptions() throws Exception
	{
		
		Logger logger = Logger.getLogger("AdminPage.class");
		adminPageImplementation admin=new adminPageImplementation();
		System.out.println("\n*******************************Admin Mode**********************************\n");
		System.out.println("1. Add Bus route\n2. Delete Bus route\n3. Update base fare\n4. Back menu\nPress any to exit");
		Scanner ip=new Scanner(System.in);
		 String choice=ip.next();
		switch (choice) {
		case "1":
			
		admin.addroute();
		adminPageOptions();
			break;
		case "2":
		
			admin.delete();
					adminPageOptions();
					break;
		case "3":
			
			admin.changeFare();
			adminPageOptions();
			break;
					
		case "4":
			logger.info("redirected to home");
			Home home=new Home();
			home.homepPageOptions();
			
			break;
		default:
			System.out.println("Thank you for Using the Application....Hava a Nice Day :)");
		
		}
	}
}
