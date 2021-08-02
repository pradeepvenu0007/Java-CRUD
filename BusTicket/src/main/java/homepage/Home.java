package homepage;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import Admin.AdminPage;
import User.UserMode;

public class Home {
	public void homepPageOptions() throws Exception {
		Logger logger = Logger.getLogger("Home.class");
		System.out.println("***********************Welcome***************************");
		System.out.println("1. Admin mode\n2. User mode\nPress any to exit");
		Scanner ip=new Scanner(System.in); 
		String choice=ip.next();
			switch (choice) {
			case "1":
			logger.info("Entering Admin mode");
			AdminPage admin=new AdminPage();
			admin.adminPageOptions();
			break;
		case "2":
			logger.info("Entering User mode");
			UserMode user=new UserMode();
			user.usermodeoptions();
			break;
		default:
			logger.info("Application process terminated.....");
			System.out.println("Thank you for Using the Application....Hava a Nice Day :)");
		}
		
		
	}
}
