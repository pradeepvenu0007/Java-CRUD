import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import DbConnection.DBUtil;

public class ApplicationTest {

	

	@Test
	public void viewtable() {
        boolean flag=false;
		
		try {
			Connection con=DBUtil.getConnection();
			Statement pst=con.createStatement();
			ResultSet rs=pst.executeQuery("show tables");
			
			if(rs.next())
				flag=true;
				
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		assertTrue(flag);
	}
	@Test
	public void BusRouteTest()
	{
boolean flag=false;
		
		try {
			Connection con=DBUtil.getConnection();
			Statement pst=con.createStatement();
			ResultSet rs=pst.executeQuery("select * from b55");
			
			if(rs.next())
				flag=true;
				
			
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		assertTrue(flag);
		
	}

}
