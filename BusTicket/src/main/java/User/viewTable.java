package User;

import java.util.Scanner;

abstract class viewTable {
	//String query="Show tables";
	abstract void displayTable() throws Exception;
	public void Acknowledge()
	{
		System.out.println("\nInfo: Press any key to acknowledge\n");
		Scanner ip=new Scanner(System.in);
		ip.nextLine();
	}
}
