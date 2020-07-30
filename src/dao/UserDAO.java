package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDAOinterface{
	ConnectionManager cm= new ConnectionManager();
	@Override
	public int signUp(User user) throws ClassNotFoundException, IOException, SQLException {
		Connection con =null;
		con=cm.getConnection();
		if(con!=null) {
		String sql = "insert into userdetails(EMAIL,PASSWORD,DATE)values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ps.setString(3,user.getDate());
		ps.executeUpdate();
		con.close();
		// TODO Auto-generated method stub
		return 1;}
		else {
			return 0;
		}
		
	}

	@Override
	public boolean loginUser(User user) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Connection con =null;
		con=cm.getConnection();
		String sql ="select * from UserDetails";
		Statement st=cm.getConnection().createStatement();
		ResultSet rs=  st.executeQuery(sql);
		while(rs.next())
		{
			if(user.getEmail().equals(rs.getString("EMAIL")) && user.getPassword().equals(rs.getString("password")))
			{
				con.close();
				return true;
			}
			else {
				return false;
			}
			
		}
		return false;
	}
}
