package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Connection con = null;
		
		Properties prop = new Properties();
		prop=loadPropertiesFile();
		Class.forName(prop.getProperty("driver"));
		con=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		return con;
	}
	
	
	public Properties loadPropertiesFile() throws IOException
	{
		Properties prop= new Properties();
		InputStream in= ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		return prop;
		
	}
}

