package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbCon1 {

	public static void main(String[] args) {
		try {
			// step 1 - loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// step 2 - Creating Connection
			Connection con = 
					DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","system","vimit");
			
			//step 3 - preparing statement
			Statement stm = con.createStatement();
			
			//step 4 - Executing queries
			ResultSet rs = stm.executeQuery("select * from User59");
			System.out.println("User Details  : ");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)
				+"\t"+rs.getLong(4));
			}//end of loop
			
			//step 5 - Closing the connection
			con.close();
		}// end of try
		catch (Exception e)
		{
			System.out.println(e.toString());
		}

	}

}
