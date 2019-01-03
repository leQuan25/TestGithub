package ketnoiCSDL;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ketnoi {
	
	public static Connection con;
//	public static String DATA="jdbc:sqlserver://ADMIN:1433;DATABASENAME=QLSV";
//	public static String USE_NAME="sa";
//	public static String PASSWORD="12345678";
	
	public static void ketnoi() throws SQLException {
		
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			con=DriverManager.getConnection(DATA,USE_NAME,PASSWORD);
//			
			
			
			Properties prop= new Properties();
			prop.load(new FileReader("data"));
			String serverclass=prop.getProperty("data.serverclass");
			String dburl=prop.getProperty("data.dburl");
			String user=prop.getProperty("data.user");
			String password=prop.getProperty("data.password");
			
			Class.forName(serverclass);
			con=DriverManager.getConnection(dburl,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnecttion(){
		if(con== null)
		{
			try {
				ketnoi();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return con;
	}
	public static Connection connectionclose() throws SQLException{
		con.close();
		return con;
		
	}
	
}